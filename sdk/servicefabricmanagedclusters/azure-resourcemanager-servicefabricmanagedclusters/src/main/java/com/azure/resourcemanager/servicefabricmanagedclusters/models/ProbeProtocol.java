// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.

package com.azure.resourcemanager.servicefabricmanagedclusters.models;

import com.azure.core.util.ExpandableStringEnum;
import java.util.Collection;

/**
 * The reference to the load balancer probe used by the load balancing rule.
 */
public final class ProbeProtocol extends ExpandableStringEnum<ProbeProtocol> {
    /**
     * Probe protocol is TCP.
     */
    public static final ProbeProtocol TCP = fromString("tcp");

    /**
     * Probe protocol is HTTP.
     */
    public static final ProbeProtocol HTTP = fromString("http");

    /**
     * Probe protocol is HTTPS.
     */
    public static final ProbeProtocol HTTPS = fromString("https");

    /**
     * Creates a new instance of ProbeProtocol value.
     * 
     * @deprecated Use the {@link #fromString(String)} factory method.
     */
    @Deprecated
    public ProbeProtocol() {
    }

    /**
     * Creates or finds a ProbeProtocol from its string representation.
     * 
     * @param name a name to look for.
     * @return the corresponding ProbeProtocol.
     */
    public static ProbeProtocol fromString(String name) {
        return fromString(name, ProbeProtocol.class);
    }

    /**
     * Gets known ProbeProtocol values.
     * 
     * @return known ProbeProtocol values.
     */
    public static Collection<ProbeProtocol> values() {
        return values(ProbeProtocol.class);
    }
}
