// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.communication.callautomation.implementation.models;

import com.azure.core.annotation.Generated;
import com.azure.core.util.ExpandableStringEnum;
import java.util.Collection;

/**
 * The identifier kind, for example 'communicationUser' or 'phoneNumber'.
 */
public final class CommunicationIdentifierModelKind extends ExpandableStringEnum<CommunicationIdentifierModelKind> {
    /**
     * Static value unknown for CommunicationIdentifierModelKind.
     */
    @Generated
    public static final CommunicationIdentifierModelKind UNKNOWN = fromString("unknown");

    /**
     * Static value communicationUser for CommunicationIdentifierModelKind.
     */
    @Generated
    public static final CommunicationIdentifierModelKind COMMUNICATION_USER = fromString("communicationUser");

    /**
     * Static value phoneNumber for CommunicationIdentifierModelKind.
     */
    @Generated
    public static final CommunicationIdentifierModelKind PHONE_NUMBER = fromString("phoneNumber");

    /**
     * Static value microsoftTeamsUser for CommunicationIdentifierModelKind.
     */
    @Generated
    public static final CommunicationIdentifierModelKind MICROSOFT_TEAMS_USER = fromString("microsoftTeamsUser");

    /**
     * Static value microsoftTeamsApp for CommunicationIdentifierModelKind.
     */
    @Generated
    public static final CommunicationIdentifierModelKind MICROSOFT_TEAMS_APP = fromString("microsoftTeamsApp");

    /**
     * Static value teamsExtensionUser for CommunicationIdentifierModelKind.
     */
    @Generated
    public static final CommunicationIdentifierModelKind TEAMS_EXTENSION_USER = fromString("teamsExtensionUser");

    /**
     * Creates a new instance of CommunicationIdentifierModelKind value.
     * 
     * @deprecated Use the {@link #fromString(String)} factory method.
     */
    @Generated
    @Deprecated
    public CommunicationIdentifierModelKind() {
    }

    /**
     * Creates or finds a CommunicationIdentifierModelKind from its string representation.
     * 
     * @param name a name to look for.
     * @return the corresponding CommunicationIdentifierModelKind.
     */
    @Generated
    public static CommunicationIdentifierModelKind fromString(String name) {
        return fromString(name, CommunicationIdentifierModelKind.class);
    }

    /**
     * Gets known CommunicationIdentifierModelKind values.
     * 
     * @return known CommunicationIdentifierModelKind values.
     */
    @Generated
    public static Collection<CommunicationIdentifierModelKind> values() {
        return values(CommunicationIdentifierModelKind.class);
    }
}
