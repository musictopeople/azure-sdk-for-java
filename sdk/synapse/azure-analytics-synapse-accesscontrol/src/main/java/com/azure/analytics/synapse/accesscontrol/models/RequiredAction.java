// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.analytics.synapse.accesscontrol.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.annotation.Generated;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;

/**
 * Action Info.
 */
@Fluent
public final class RequiredAction implements JsonSerializable<RequiredAction> {
    /*
     * Action Id.
     */
    @Generated
    private String id;

    /*
     * Is a data action or not.
     */
    @Generated
    private boolean isDataAction;

    /**
     * Creates an instance of RequiredAction class.
     */
    @Generated
    public RequiredAction() {
    }

    /**
     * Get the id property: Action Id.
     * 
     * @return the id value.
     */
    @Generated
    public String getId() {
        return this.id;
    }

    /**
     * Set the id property: Action Id.
     * 
     * @param id the id value to set.
     * @return the RequiredAction object itself.
     */
    @Generated
    public RequiredAction setId(String id) {
        this.id = id;
        return this;
    }

    /**
     * Get the isDataAction property: Is a data action or not.
     * 
     * @return the isDataAction value.
     */
    @Generated
    public boolean isDataAction() {
        return this.isDataAction;
    }

    /**
     * Set the isDataAction property: Is a data action or not.
     * 
     * @param isDataAction the isDataAction value to set.
     * @return the RequiredAction object itself.
     */
    @Generated
    public RequiredAction setIsDataAction(boolean isDataAction) {
        this.isDataAction = isDataAction;
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Generated
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeStringField("id", this.id);
        jsonWriter.writeBooleanField("isDataAction", this.isDataAction);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of RequiredAction from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of RequiredAction if the JsonReader was pointing to an instance of it, or null if it was
     * pointing to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the RequiredAction.
     */
    @Generated
    public static RequiredAction fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            RequiredAction deserializedRequiredAction = new RequiredAction();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("id".equals(fieldName)) {
                    deserializedRequiredAction.id = reader.getString();
                } else if ("isDataAction".equals(fieldName)) {
                    deserializedRequiredAction.isDataAction = reader.getBoolean();
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedRequiredAction;
        });
    }
}
