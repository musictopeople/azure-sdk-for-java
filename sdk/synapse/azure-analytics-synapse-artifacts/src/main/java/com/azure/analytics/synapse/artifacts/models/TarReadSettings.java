// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.analytics.synapse.artifacts.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.annotation.Generated;
import com.azure.json.JsonReader;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * The Tar compression read settings.
 */
@Fluent
public final class TarReadSettings extends CompressionReadSettings {
    /*
     * The Compression setting type.
     */
    @Generated
    private String type = "TarReadSettings";

    /*
     * Preserve the compression file name as folder path. Type: boolean (or Expression with resultType boolean).
     */
    @Generated
    private Object preserveCompressionFileNameAsFolder;

    /**
     * Creates an instance of TarReadSettings class.
     */
    @Generated
    public TarReadSettings() {
    }

    /**
     * Get the type property: The Compression setting type.
     * 
     * @return the type value.
     */
    @Generated
    @Override
    public String getType() {
        return this.type;
    }

    /**
     * Get the preserveCompressionFileNameAsFolder property: Preserve the compression file name as folder path. Type:
     * boolean (or Expression with resultType boolean).
     * 
     * @return the preserveCompressionFileNameAsFolder value.
     */
    @Generated
    public Object getPreserveCompressionFileNameAsFolder() {
        return this.preserveCompressionFileNameAsFolder;
    }

    /**
     * Set the preserveCompressionFileNameAsFolder property: Preserve the compression file name as folder path. Type:
     * boolean (or Expression with resultType boolean).
     * 
     * @param preserveCompressionFileNameAsFolder the preserveCompressionFileNameAsFolder value to set.
     * @return the TarReadSettings object itself.
     */
    @Generated
    public TarReadSettings setPreserveCompressionFileNameAsFolder(Object preserveCompressionFileNameAsFolder) {
        this.preserveCompressionFileNameAsFolder = preserveCompressionFileNameAsFolder;
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Generated
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeStringField("type", this.type);
        if (this.preserveCompressionFileNameAsFolder != null) {
            jsonWriter.writeUntypedField("preserveCompressionFileNameAsFolder",
                this.preserveCompressionFileNameAsFolder);
        }
        if (getAdditionalProperties() != null) {
            for (Map.Entry<String, Object> additionalProperty : getAdditionalProperties().entrySet()) {
                jsonWriter.writeUntypedField(additionalProperty.getKey(), additionalProperty.getValue());
            }
        }
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of TarReadSettings from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of TarReadSettings if the JsonReader was pointing to an instance of it, or null if it was
     * pointing to JSON null.
     * @throws IOException If an error occurs while reading the TarReadSettings.
     */
    @Generated
    public static TarReadSettings fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            TarReadSettings deserializedTarReadSettings = new TarReadSettings();
            Map<String, Object> additionalProperties = null;
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("type".equals(fieldName)) {
                    deserializedTarReadSettings.type = reader.getString();
                } else if ("preserveCompressionFileNameAsFolder".equals(fieldName)) {
                    deserializedTarReadSettings.preserveCompressionFileNameAsFolder = reader.readUntyped();
                } else {
                    if (additionalProperties == null) {
                        additionalProperties = new LinkedHashMap<>();
                    }

                    additionalProperties.put(fieldName, reader.readUntyped());
                }
            }
            deserializedTarReadSettings.setAdditionalProperties(additionalProperties);

            return deserializedTarReadSettings;
        });
    }
}
