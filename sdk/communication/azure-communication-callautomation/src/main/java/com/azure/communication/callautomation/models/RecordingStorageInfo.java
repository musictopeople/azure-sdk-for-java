// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.communication.callautomation.models;

import java.io.IOException;
import java.util.List;

import com.azure.communication.callautomation.implementation.models.RecordingChunkStorageInfo;
import com.azure.core.annotation.Fluent;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;

/**
 * Container for chunks.
 */
@Fluent
public final class RecordingStorageInfo implements JsonSerializable<RecordingStorageInfo> {
    /*
     * Collection of {Microsoft.Skype.Platform.ExecutionAgent.Azure.Communication.Service.ServerCalling.Content.Contracts.ALPHA4_2024_09_01_preview.Models.RecordingChunkStorageInfo}
     */
    private List<RecordingChunkStorageInfo> recordingChunks;

    /**
     * Creates an instance of RecordingStorageInfo class.
     */
    public RecordingStorageInfo() {
    }

    /**
     * Get the recordingChunks property: Collection of
     * {Microsoft.Skype.Platform.ExecutionAgent.Azure.Communication.Service.ServerCalling.Content.Contracts.ALPHA4_2024_09_01_preview.Models.RecordingChunkStorageInfo}.
     * 
     * @return the recordingChunks value.
     */
    public List<RecordingChunkStorageInfo> getRecordingChunks() {
        return this.recordingChunks;
    }

    /**
     * Set the recordingChunks property: Collection of
     * {Microsoft.Skype.Platform.ExecutionAgent.Azure.Communication.Service.ServerCalling.Content.Contracts.ALPHA4_2024_09_01_preview.Models.RecordingChunkStorageInfo}.
     * 
     * @param recordingChunks the recordingChunks value to set.
     * @return the RecordingStorageInfo object itself.
     */
    public RecordingStorageInfo setRecordingChunks(List<RecordingChunkStorageInfo> recordingChunks) {
        this.recordingChunks = recordingChunks;
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeArrayField("recordingChunks", this.recordingChunks,
            (writer, element) -> writer.writeJson(element));
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of RecordingStorageInfo from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of RecordingStorageInfo if the JsonReader was pointing to an instance of it, or null if it
     * was pointing to JSON null.
     * @throws IOException If an error occurs while reading the RecordingStorageInfo.
     */
    public static RecordingStorageInfo fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            RecordingStorageInfo deserializedRecordingStorageInfo = new RecordingStorageInfo();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("recordingChunks".equals(fieldName)) {
                    List<RecordingChunkStorageInfo> recordingChunks
                        = reader.readArray(reader1 -> RecordingChunkStorageInfo.fromJson(reader1));
                    deserializedRecordingStorageInfo.recordingChunks = recordingChunks;
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedRecordingStorageInfo;
        });
    }
}
