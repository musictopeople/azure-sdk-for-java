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
import java.util.List;
import java.util.Map;

/**
 * Microsoft Azure CosmosDB (SQL API) Collection dataset.
 */
@Fluent
public class CosmosDbSqlApiCollectionDataset extends Dataset {
    /*
     * Type of dataset.
     */
    @Generated
    private String type = "CosmosDbSqlApiCollection";

    /*
     * CosmosDB (SQL API) collection name. Type: string (or Expression with resultType string).
     */
    @Generated
    private Object collectionName;

    /**
     * Creates an instance of CosmosDbSqlApiCollectionDataset class.
     */
    @Generated
    public CosmosDbSqlApiCollectionDataset() {
    }

    /**
     * Get the type property: Type of dataset.
     * 
     * @return the type value.
     */
    @Generated
    @Override
    public String getType() {
        return this.type;
    }

    /**
     * Get the collectionName property: CosmosDB (SQL API) collection name. Type: string (or Expression with resultType
     * string).
     * 
     * @return the collectionName value.
     */
    @Generated
    public Object getCollectionName() {
        return this.collectionName;
    }

    /**
     * Set the collectionName property: CosmosDB (SQL API) collection name. Type: string (or Expression with resultType
     * string).
     * 
     * @param collectionName the collectionName value to set.
     * @return the CosmosDbSqlApiCollectionDataset object itself.
     */
    @Generated
    public CosmosDbSqlApiCollectionDataset setCollectionName(Object collectionName) {
        this.collectionName = collectionName;
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Generated
    @Override
    public CosmosDbSqlApiCollectionDataset setDescription(String description) {
        super.setDescription(description);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Generated
    @Override
    public CosmosDbSqlApiCollectionDataset setStructure(Object structure) {
        super.setStructure(structure);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Generated
    @Override
    public CosmosDbSqlApiCollectionDataset setSchema(Object schema) {
        super.setSchema(schema);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Generated
    @Override
    public CosmosDbSqlApiCollectionDataset setLinkedServiceName(LinkedServiceReference linkedServiceName) {
        super.setLinkedServiceName(linkedServiceName);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Generated
    @Override
    public CosmosDbSqlApiCollectionDataset setParameters(Map<String, ParameterSpecification> parameters) {
        super.setParameters(parameters);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Generated
    @Override
    public CosmosDbSqlApiCollectionDataset setAnnotations(List<Object> annotations) {
        super.setAnnotations(annotations);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Generated
    @Override
    public CosmosDbSqlApiCollectionDataset setFolder(DatasetFolder folder) {
        super.setFolder(folder);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Generated
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeJsonField("linkedServiceName", getLinkedServiceName());
        jsonWriter.writeStringField("description", getDescription());
        if (getStructure() != null) {
            jsonWriter.writeUntypedField("structure", getStructure());
        }
        if (getSchema() != null) {
            jsonWriter.writeUntypedField("schema", getSchema());
        }
        jsonWriter.writeMapField("parameters", getParameters(), (writer, element) -> writer.writeJson(element));
        jsonWriter.writeArrayField("annotations", getAnnotations(), (writer, element) -> writer.writeUntyped(element));
        jsonWriter.writeJsonField("folder", getFolder());
        jsonWriter.writeStringField("type", this.type);
        if (collectionName != null) {
            jsonWriter.writeStartObject("typeProperties");
            jsonWriter.writeUntypedField("collectionName", this.collectionName);
            jsonWriter.writeEndObject();
        }
        if (getAdditionalProperties() != null) {
            for (Map.Entry<String, Object> additionalProperty : getAdditionalProperties().entrySet()) {
                jsonWriter.writeUntypedField(additionalProperty.getKey(), additionalProperty.getValue());
            }
        }
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of CosmosDbSqlApiCollectionDataset from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of CosmosDbSqlApiCollectionDataset if the JsonReader was pointing to an instance of it, or
     * null if it was pointing to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the CosmosDbSqlApiCollectionDataset.
     */
    @Generated
    public static CosmosDbSqlApiCollectionDataset fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            CosmosDbSqlApiCollectionDataset deserializedCosmosDbSqlApiCollectionDataset
                = new CosmosDbSqlApiCollectionDataset();
            Map<String, Object> additionalProperties = null;
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("linkedServiceName".equals(fieldName)) {
                    deserializedCosmosDbSqlApiCollectionDataset
                        .setLinkedServiceName(LinkedServiceReference.fromJson(reader));
                } else if ("description".equals(fieldName)) {
                    deserializedCosmosDbSqlApiCollectionDataset.setDescription(reader.getString());
                } else if ("structure".equals(fieldName)) {
                    deserializedCosmosDbSqlApiCollectionDataset.setStructure(reader.readUntyped());
                } else if ("schema".equals(fieldName)) {
                    deserializedCosmosDbSqlApiCollectionDataset.setSchema(reader.readUntyped());
                } else if ("parameters".equals(fieldName)) {
                    Map<String, ParameterSpecification> parameters
                        = reader.readMap(reader1 -> ParameterSpecification.fromJson(reader1));
                    deserializedCosmosDbSqlApiCollectionDataset.setParameters(parameters);
                } else if ("annotations".equals(fieldName)) {
                    List<Object> annotations = reader.readArray(reader1 -> reader1.readUntyped());
                    deserializedCosmosDbSqlApiCollectionDataset.setAnnotations(annotations);
                } else if ("folder".equals(fieldName)) {
                    deserializedCosmosDbSqlApiCollectionDataset.setFolder(DatasetFolder.fromJson(reader));
                } else if ("type".equals(fieldName)) {
                    deserializedCosmosDbSqlApiCollectionDataset.type = reader.getString();
                } else if ("typeProperties".equals(fieldName) && reader.currentToken() == JsonToken.START_OBJECT) {
                    while (reader.nextToken() != JsonToken.END_OBJECT) {
                        fieldName = reader.getFieldName();
                        reader.nextToken();

                        if ("collectionName".equals(fieldName)) {
                            deserializedCosmosDbSqlApiCollectionDataset.collectionName = reader.readUntyped();
                        } else {
                            reader.skipChildren();
                        }
                    }
                } else {
                    if (additionalProperties == null) {
                        additionalProperties = new LinkedHashMap<>();
                    }

                    additionalProperties.put(fieldName, reader.readUntyped());
                }
            }
            deserializedCosmosDbSqlApiCollectionDataset.setAdditionalProperties(additionalProperties);

            return deserializedCosmosDbSqlApiCollectionDataset;
        });
    }
}
