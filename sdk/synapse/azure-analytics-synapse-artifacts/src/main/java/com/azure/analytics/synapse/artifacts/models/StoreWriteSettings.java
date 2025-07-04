// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.analytics.synapse.artifacts.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.annotation.Generated;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Connector write settings.
 */
@Fluent
public class StoreWriteSettings implements JsonSerializable<StoreWriteSettings> {
    /*
     * The write setting type.
     */
    @Generated
    private String type = "StoreWriteSettings";

    /*
     * The maximum concurrent connection count for the source data store. Type: integer (or Expression with resultType
     * integer).
     */
    @Generated
    private Object maxConcurrentConnections;

    /*
     * The type of copy behavior for copy sink.
     */
    @Generated
    private Object copyBehavior;

    /*
     * Specify the custom metadata to be added to sink data. Type: array of objects (or Expression with resultType array
     * of objects).
     */
    @Generated
    private List<MetadataItem> metadata;

    /*
     * Connector write settings.
     */
    @Generated
    private Map<String, Object> additionalProperties;

    /**
     * Creates an instance of StoreWriteSettings class.
     */
    @Generated
    public StoreWriteSettings() {
    }

    /**
     * Get the type property: The write setting type.
     * 
     * @return the type value.
     */
    @Generated
    public String getType() {
        return this.type;
    }

    /**
     * Get the maxConcurrentConnections property: The maximum concurrent connection count for the source data store.
     * Type: integer (or Expression with resultType integer).
     * 
     * @return the maxConcurrentConnections value.
     */
    @Generated
    public Object getMaxConcurrentConnections() {
        return this.maxConcurrentConnections;
    }

    /**
     * Set the maxConcurrentConnections property: The maximum concurrent connection count for the source data store.
     * Type: integer (or Expression with resultType integer).
     * 
     * @param maxConcurrentConnections the maxConcurrentConnections value to set.
     * @return the StoreWriteSettings object itself.
     */
    @Generated
    public StoreWriteSettings setMaxConcurrentConnections(Object maxConcurrentConnections) {
        this.maxConcurrentConnections = maxConcurrentConnections;
        return this;
    }

    /**
     * Get the copyBehavior property: The type of copy behavior for copy sink.
     * 
     * @return the copyBehavior value.
     */
    @Generated
    public Object getCopyBehavior() {
        return this.copyBehavior;
    }

    /**
     * Set the copyBehavior property: The type of copy behavior for copy sink.
     * 
     * @param copyBehavior the copyBehavior value to set.
     * @return the StoreWriteSettings object itself.
     */
    @Generated
    public StoreWriteSettings setCopyBehavior(Object copyBehavior) {
        this.copyBehavior = copyBehavior;
        return this;
    }

    /**
     * Get the metadata property: Specify the custom metadata to be added to sink data. Type: array of objects (or
     * Expression with resultType array of objects).
     * 
     * @return the metadata value.
     */
    @Generated
    public List<MetadataItem> getMetadata() {
        return this.metadata;
    }

    /**
     * Set the metadata property: Specify the custom metadata to be added to sink data. Type: array of objects (or
     * Expression with resultType array of objects).
     * 
     * @param metadata the metadata value to set.
     * @return the StoreWriteSettings object itself.
     */
    @Generated
    public StoreWriteSettings setMetadata(List<MetadataItem> metadata) {
        this.metadata = metadata;
        return this;
    }

    /**
     * Get the additionalProperties property: Connector write settings.
     * 
     * @return the additionalProperties value.
     */
    @Generated
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    /**
     * Set the additionalProperties property: Connector write settings.
     * 
     * @param additionalProperties the additionalProperties value to set.
     * @return the StoreWriteSettings object itself.
     */
    @Generated
    public StoreWriteSettings setAdditionalProperties(Map<String, Object> additionalProperties) {
        this.additionalProperties = additionalProperties;
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
        if (this.maxConcurrentConnections != null) {
            jsonWriter.writeUntypedField("maxConcurrentConnections", this.maxConcurrentConnections);
        }
        if (this.copyBehavior != null) {
            jsonWriter.writeUntypedField("copyBehavior", this.copyBehavior);
        }
        jsonWriter.writeArrayField("metadata", this.metadata, (writer, element) -> writer.writeJson(element));
        if (additionalProperties != null) {
            for (Map.Entry<String, Object> additionalProperty : additionalProperties.entrySet()) {
                jsonWriter.writeUntypedField(additionalProperty.getKey(), additionalProperty.getValue());
            }
        }
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of StoreWriteSettings from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of StoreWriteSettings if the JsonReader was pointing to an instance of it, or null if it was
     * pointing to JSON null.
     * @throws IOException If an error occurs while reading the StoreWriteSettings.
     */
    @Generated
    public static StoreWriteSettings fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            String discriminatorValue = null;
            try (JsonReader readerToUse = reader.bufferObject()) {
                readerToUse.nextToken(); // Prepare for reading
                while (readerToUse.nextToken() != JsonToken.END_OBJECT) {
                    String fieldName = readerToUse.getFieldName();
                    readerToUse.nextToken();
                    if ("type".equals(fieldName)) {
                        discriminatorValue = readerToUse.getString();
                        break;
                    } else {
                        readerToUse.skipChildren();
                    }
                }
                // Use the discriminator value to determine which subtype should be deserialized.
                if ("SftpWriteSettings".equals(discriminatorValue)) {
                    return SftpWriteSettings.fromJson(readerToUse.reset());
                } else if ("AzureBlobStorageWriteSettings".equals(discriminatorValue)) {
                    return AzureBlobStorageWriteSettings.fromJson(readerToUse.reset());
                } else if ("AzureBlobFSWriteSettings".equals(discriminatorValue)) {
                    return AzureBlobFSWriteSettings.fromJson(readerToUse.reset());
                } else if ("AzureDataLakeStoreWriteSettings".equals(discriminatorValue)) {
                    return AzureDataLakeStoreWriteSettings.fromJson(readerToUse.reset());
                } else if ("FileServerWriteSettings".equals(discriminatorValue)) {
                    return FileServerWriteSettings.fromJson(readerToUse.reset());
                } else if ("AzureFileStorageWriteSettings".equals(discriminatorValue)) {
                    return AzureFileStorageWriteSettings.fromJson(readerToUse.reset());
                } else if ("LakeHouseWriteSettings".equals(discriminatorValue)) {
                    return LakeHouseWriteSettings.fromJson(readerToUse.reset());
                } else {
                    return fromJsonKnownDiscriminator(readerToUse.reset());
                }
            }
        });
    }

    @Generated
    static StoreWriteSettings fromJsonKnownDiscriminator(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            StoreWriteSettings deserializedStoreWriteSettings = new StoreWriteSettings();
            Map<String, Object> additionalProperties = null;
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("type".equals(fieldName)) {
                    deserializedStoreWriteSettings.type = reader.getString();
                } else if ("maxConcurrentConnections".equals(fieldName)) {
                    deserializedStoreWriteSettings.maxConcurrentConnections = reader.readUntyped();
                } else if ("copyBehavior".equals(fieldName)) {
                    deserializedStoreWriteSettings.copyBehavior = reader.readUntyped();
                } else if ("metadata".equals(fieldName)) {
                    List<MetadataItem> metadata = reader.readArray(reader1 -> MetadataItem.fromJson(reader1));
                    deserializedStoreWriteSettings.metadata = metadata;
                } else {
                    if (additionalProperties == null) {
                        additionalProperties = new LinkedHashMap<>();
                    }

                    additionalProperties.put(fieldName, reader.readUntyped());
                }
            }
            deserializedStoreWriteSettings.additionalProperties = additionalProperties;

            return deserializedStoreWriteSettings;
        });
    }
}
