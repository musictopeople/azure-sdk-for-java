// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.ai.textanalytics.implementation.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.annotation.Generated;
import com.azure.json.JsonReader;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;
import java.util.List;

/**
 * The LinkedEntitiesDocumentResult model.
 */
@Fluent
public class LinkedEntitiesDocumentResult extends DocumentResult {
    /*
     * Recognized well known entities in the document.
     */
    @Generated
    private List<LinkedEntity> entities;

    /**
     * Creates an instance of LinkedEntitiesDocumentResult class.
     */
    @Generated
    public LinkedEntitiesDocumentResult() {
    }

    /**
     * Get the entities property: Recognized well known entities in the document.
     * 
     * @return the entities value.
     */
    @Generated
    public List<LinkedEntity> getEntities() {
        return this.entities;
    }

    /**
     * Set the entities property: Recognized well known entities in the document.
     * 
     * @param entities the entities value to set.
     * @return the LinkedEntitiesDocumentResult object itself.
     */
    @Generated
    public LinkedEntitiesDocumentResult setEntities(List<LinkedEntity> entities) {
        this.entities = entities;
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Generated
    @Override
    public LinkedEntitiesDocumentResult setId(String id) {
        super.setId(id);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Generated
    @Override
    public LinkedEntitiesDocumentResult setWarnings(List<DocumentWarning> warnings) {
        super.setWarnings(warnings);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Generated
    @Override
    public LinkedEntitiesDocumentResult setStatistics(DocumentStatistics statistics) {
        super.setStatistics(statistics);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Generated
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeStringField("id", getId());
        jsonWriter.writeArrayField("warnings", getWarnings(), (writer, element) -> writer.writeJson(element));
        jsonWriter.writeJsonField("statistics", getStatistics());
        jsonWriter.writeArrayField("entities", this.entities, (writer, element) -> writer.writeJson(element));
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of LinkedEntitiesDocumentResult from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of LinkedEntitiesDocumentResult if the JsonReader was pointing to an instance of it, or null
     * if it was pointing to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the LinkedEntitiesDocumentResult.
     */
    @Generated
    public static LinkedEntitiesDocumentResult fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            LinkedEntitiesDocumentResult deserializedLinkedEntitiesDocumentResult = new LinkedEntitiesDocumentResult();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("id".equals(fieldName)) {
                    deserializedLinkedEntitiesDocumentResult.setId(reader.getString());
                } else if ("warnings".equals(fieldName)) {
                    List<DocumentWarning> warnings = reader.readArray(reader1 -> DocumentWarning.fromJson(reader1));
                    deserializedLinkedEntitiesDocumentResult.setWarnings(warnings);
                } else if ("statistics".equals(fieldName)) {
                    deserializedLinkedEntitiesDocumentResult.setStatistics(DocumentStatistics.fromJson(reader));
                } else if ("entities".equals(fieldName)) {
                    List<LinkedEntity> entities = reader.readArray(reader1 -> LinkedEntity.fromJson(reader1));
                    deserializedLinkedEntitiesDocumentResult.entities = entities;
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedLinkedEntitiesDocumentResult;
        });
    }
}
