// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
package io.clientcore.http.netty4.implementation;

import io.clientcore.core.utils.IOExceptionCheckedConsumer;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufHolder;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandler;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.http.LastHttpContent;
import io.netty.handler.codec.http2.Http2DataFrame;
import io.netty.util.ReferenceCountUtil;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/**
 * {@link ChannelInboundHandler} that initiates one read request any time data is needed. Even though it is a single
 * read request it may result in multiple {@link #channelRead(ChannelHandlerContext, Object)} invocations. Consumers of
 * this handler need to support multiple channelRead, if this isn't done data may be lost.
 */
public final class Netty4InitiateOneReadHandler extends ChannelInboundHandlerAdapter {
    private final IOExceptionCheckedConsumer<ByteBuf> byteBufConsumer;
    private final boolean isHttp2;

    private CountDownLatch latch;

    private boolean lastRead;
    private Throwable exception;

    /**
     * Creates a new instance of {@link Netty4InitiateOneReadHandler}.
     * <p>
     * The passed {@link CountDownLatch} will count down when {@link #channelReadComplete(ChannelHandlerContext)} fires.
     * This indicates that the single read operation completed, it doesn't necessarily mean that the channel was fully
     * read.
     *
     * @param latch The latch to count down when the channel read completes.
     * @param byteBufConsumer The consumer to process the {@link ByteBuf ByteBufs} as they are read.
     * @param isHttp2 Flag indicating whether the handler is used for HTTP/2 or not.
     */
    public Netty4InitiateOneReadHandler(CountDownLatch latch, IOExceptionCheckedConsumer<ByteBuf> byteBufConsumer,
        boolean isHttp2) {
        this.latch = latch;
        this.byteBufConsumer = byteBufConsumer;
        this.isHttp2 = isHttp2;
    }

    /**
     * Sets the latch to count down when the channel read completes.
     *
     * @param latch The latch to count down when the channel read completes.
     */
    void setLatch(CountDownLatch latch) {
        if (this.latch != null && this.latch.getCount() != 0) {
            throw new IllegalStateException("Cannot set a new latch while the previous latch hasn't completed.");
        }
        this.latch = latch;
    }

    @Override
    public boolean isSharable() {
        return false;
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        ByteBuf buf = null;
        if (msg instanceof ByteBufHolder) {
            buf = ((ByteBufHolder) msg).content();
        } else if (msg instanceof ByteBuf) {
            buf = (ByteBuf) msg;
        }

        if (buf != null && buf.isReadable()) {
            try {
                byteBufConsumer.accept(buf);
            } catch (IOException | RuntimeException ex) {
                ReferenceCountUtil.release(buf);
                ctx.close();
                return;
            }
        }

        if (isHttp2) {
            lastRead = msg instanceof Http2DataFrame && ((Http2DataFrame) msg).isEndStream();
        } else {
            lastRead = msg instanceof LastHttpContent;
        }
        ctx.fireChannelRead(msg);
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) {
        latch.countDown();
        if (lastRead) {
            ctx.pipeline().remove(this);
            ctx.close();
        }
    }

    boolean isChannelConsumed() {
        return lastRead;
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        this.exception = cause;
        latch.countDown();
        ctx.close();
    }

    Throwable channelException() {
        return exception;
    }

    // TODO (alzimmer): Are the latch countdowns needed for unregistering and inactivity?
    @Override
    public void channelUnregistered(ChannelHandlerContext ctx) {
        latch.countDown();
        ctx.fireChannelUnregistered();
        ctx.pipeline().remove(this);
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) {
        latch.countDown();
        ctx.fireChannelInactive();
        ctx.pipeline().remove(this);
    }
}
