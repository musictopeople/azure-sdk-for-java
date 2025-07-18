// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.
package com.azure.messaging.eventgrid.systemevents;

import com.azure.core.annotation.Fluent;
import com.azure.core.annotation.Generated;
import com.azure.core.util.CoreUtils;
import com.azure.json.JsonReader;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

/**
 * Schema of the Data property of an EventGridEvent for a Microsoft.Communication.ChatMessageReceivedInThread event.
 * 
 * @deprecated This class is deprecated and may be removed in future releases. System events are now available in the
 * azure-messaging-eventgrid-systemevents package.
 */
@Fluent
@Deprecated
public final class AcsChatMessageReceivedInThreadEventData extends AcsChatMessageEventInThreadBaseProperties {

    /*
     * The body of the chat message
     */
    @Generated
    private String messageBody;

    /*
     * The chat message metadata
     */
    @Generated
    private Map<String, String> metadata;

    /**
     * Creates an instance of AcsChatMessageReceivedInThreadEventData class.
     */
    @Generated
    public AcsChatMessageReceivedInThreadEventData() {
    }

    /**
     * Get the messageBody property: The body of the chat message.
     *
     * @return the messageBody value.
     */
    @Generated
    public String getMessageBody() {
        return this.messageBody;
    }

    /**
     * Set the messageBody property: The body of the chat message.
     *
     * @param messageBody the messageBody value to set.
     * @return the AcsChatMessageReceivedInThreadEventData object itself.
     */
    @Generated
    public AcsChatMessageReceivedInThreadEventData setMessageBody(String messageBody) {
        this.messageBody = messageBody;
        return this;
    }

    /**
     * Get the metadata property: The chat message metadata.
     *
     * @return the metadata value.
     */
    @Generated
    public Map<String, String> getMetadata() {
        return this.metadata;
    }

    /**
     * Set the metadata property: The chat message metadata.
     *
     * @param metadata the metadata value to set.
     * @return the AcsChatMessageReceivedInThreadEventData object itself.
     */
    @Generated
    public AcsChatMessageReceivedInThreadEventData setMetadata(Map<String, String> metadata) {
        this.metadata = metadata;
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Generated
    @Override
    public AcsChatMessageReceivedInThreadEventData setMessageId(String messageId) {
        super.setMessageId(messageId);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Generated
    @Override
    public AcsChatMessageReceivedInThreadEventData
        setSenderCommunicationIdentifier(CommunicationIdentifierModel senderCommunicationIdentifier) {
        super.setSenderCommunicationIdentifier(senderCommunicationIdentifier);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Generated
    @Override
    public AcsChatMessageReceivedInThreadEventData setSenderDisplayName(String senderDisplayName) {
        super.setSenderDisplayName(senderDisplayName);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Generated
    @Override
    public AcsChatMessageReceivedInThreadEventData setComposeTime(OffsetDateTime composeTime) {
        super.setComposeTime(composeTime);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Generated
    @Override
    public AcsChatMessageReceivedInThreadEventData setType(String type) {
        super.setType(type);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Generated
    @Override
    public AcsChatMessageReceivedInThreadEventData setVersion(Long version) {
        super.setVersion(version);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Generated
    @Override
    public AcsChatMessageReceivedInThreadEventData setTransactionId(String transactionId) {
        super.setTransactionId(transactionId);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Generated
    @Override
    public AcsChatMessageReceivedInThreadEventData setThreadId(String threadId) {
        super.setThreadId(threadId);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Generated
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeStringField("transactionId", getTransactionId());
        jsonWriter.writeStringField("threadId", getThreadId());
        jsonWriter.writeStringField("messageId", getMessageId());
        jsonWriter.writeJsonField("senderCommunicationIdentifier", getSenderCommunicationIdentifier());
        jsonWriter.writeStringField("type", getType());
        jsonWriter.writeStringField("senderDisplayName", getSenderDisplayName());
        jsonWriter.writeStringField("composeTime",
            getComposeTime() == null ? null : DateTimeFormatter.ISO_OFFSET_DATE_TIME.format(getComposeTime()));
        jsonWriter.writeNumberField("version", getVersion());
        jsonWriter.writeStringField("messageBody", this.messageBody);
        jsonWriter.writeMapField("metadata", this.metadata, (writer, element) -> writer.writeString(element));
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of AcsChatMessageReceivedInThreadEventData from the JsonReader.
     *
     * @param jsonReader The JsonReader being read.
     * @return An instance of AcsChatMessageReceivedInThreadEventData if the JsonReader was pointing to an instance of
     * it, or null if it was pointing to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the AcsChatMessageReceivedInThreadEventData.
     */
    @Generated
    public static AcsChatMessageReceivedInThreadEventData fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            AcsChatMessageReceivedInThreadEventData deserializedAcsChatMessageReceivedInThreadEventData
                = new AcsChatMessageReceivedInThreadEventData();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();
                if ("transactionId".equals(fieldName)) {
                    deserializedAcsChatMessageReceivedInThreadEventData.setTransactionId(reader.getString());
                } else if ("threadId".equals(fieldName)) {
                    deserializedAcsChatMessageReceivedInThreadEventData.setThreadId(reader.getString());
                } else if ("messageId".equals(fieldName)) {
                    deserializedAcsChatMessageReceivedInThreadEventData.setMessageId(reader.getString());
                } else if ("senderCommunicationIdentifier".equals(fieldName)) {
                    deserializedAcsChatMessageReceivedInThreadEventData
                        .setSenderCommunicationIdentifier(CommunicationIdentifierModel.fromJson(reader));
                } else if ("type".equals(fieldName)) {
                    deserializedAcsChatMessageReceivedInThreadEventData.setType(reader.getString());
                } else if ("senderDisplayName".equals(fieldName)) {
                    deserializedAcsChatMessageReceivedInThreadEventData.setSenderDisplayName(reader.getString());
                } else if ("composeTime".equals(fieldName)) {
                    deserializedAcsChatMessageReceivedInThreadEventData.setComposeTime(reader
                        .getNullable(nonNullReader -> CoreUtils.parseBestOffsetDateTime(nonNullReader.getString())));
                } else if ("version".equals(fieldName)) {
                    deserializedAcsChatMessageReceivedInThreadEventData
                        .setVersion(reader.getNullable(JsonReader::getLong));
                } else if ("messageBody".equals(fieldName)) {
                    deserializedAcsChatMessageReceivedInThreadEventData.messageBody = reader.getString();
                } else if ("metadata".equals(fieldName)) {
                    Map<String, String> metadata = reader.readMap(reader1 -> reader1.getString());
                    deserializedAcsChatMessageReceivedInThreadEventData.metadata = metadata;
                } else {
                    reader.skipChildren();
                }
            }
            return deserializedAcsChatMessageReceivedInThreadEventData;
        });
    }
}
