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
 * Pipeline resource type.
 */
@Fluent
public class PipelineResource extends SubResource {
    /*
     * The description of the pipeline.
     */
    @Generated
    private String description;

    /*
     * List of activities in pipeline.
     */
    @Generated
    private List<Activity> activities;

    /*
     * List of parameters for pipeline.
     */
    @Generated
    private Map<String, ParameterSpecification> parameters;

    /*
     * List of variables for pipeline.
     */
    @Generated
    private Map<String, VariableSpecification> variables;

    /*
     * The max number of concurrent runs for the pipeline.
     */
    @Generated
    private Integer concurrency;

    /*
     * List of tags that can be used for describing the Pipeline.
     */
    @Generated
    private List<Object> annotations;

    /*
     * Dimensions emitted by Pipeline.
     */
    @Generated
    private Map<String, Object> runDimensions;

    /*
     * The folder that this Pipeline is in. If not specified, Pipeline will appear at the root level.
     */
    @Generated
    private PipelineFolder folder;

    /*
     * Pipeline resource type.
     */
    @Generated
    private Map<String, Object> additionalProperties;

    /*
     * Resource Etag.
     */
    @Generated
    private String etag;

    /*
     * The type of the resource. E.g. "Microsoft.Compute/virtualMachines" or "Microsoft.Storage/storageAccounts"
     */
    @Generated
    private String type;

    /*
     * The name of the resource
     */
    @Generated
    private String name;

    /*
     * Fully qualified resource ID for the resource. Ex -
     * /subscriptions/{subscriptionId}/resourceGroups/{resourceGroupName}/providers/{resourceProviderNamespace}/{
     * resourceType}/{resourceName}
     */
    @Generated
    private String id;

    /**
     * Creates an instance of PipelineResource class.
     */
    @Generated
    public PipelineResource() {
    }

    /**
     * Get the description property: The description of the pipeline.
     * 
     * @return the description value.
     */
    @Generated
    public String getDescription() {
        return this.description;
    }

    /**
     * Set the description property: The description of the pipeline.
     * 
     * @param description the description value to set.
     * @return the PipelineResource object itself.
     */
    @Generated
    public PipelineResource setDescription(String description) {
        this.description = description;
        return this;
    }

    /**
     * Get the activities property: List of activities in pipeline.
     * 
     * @return the activities value.
     */
    @Generated
    public List<Activity> getActivities() {
        return this.activities;
    }

    /**
     * Set the activities property: List of activities in pipeline.
     * 
     * @param activities the activities value to set.
     * @return the PipelineResource object itself.
     */
    @Generated
    public PipelineResource setActivities(List<Activity> activities) {
        this.activities = activities;
        return this;
    }

    /**
     * Get the parameters property: List of parameters for pipeline.
     * 
     * @return the parameters value.
     */
    @Generated
    public Map<String, ParameterSpecification> getParameters() {
        return this.parameters;
    }

    /**
     * Set the parameters property: List of parameters for pipeline.
     * 
     * @param parameters the parameters value to set.
     * @return the PipelineResource object itself.
     */
    @Generated
    public PipelineResource setParameters(Map<String, ParameterSpecification> parameters) {
        this.parameters = parameters;
        return this;
    }

    /**
     * Get the variables property: List of variables for pipeline.
     * 
     * @return the variables value.
     */
    @Generated
    public Map<String, VariableSpecification> getVariables() {
        return this.variables;
    }

    /**
     * Set the variables property: List of variables for pipeline.
     * 
     * @param variables the variables value to set.
     * @return the PipelineResource object itself.
     */
    @Generated
    public PipelineResource setVariables(Map<String, VariableSpecification> variables) {
        this.variables = variables;
        return this;
    }

    /**
     * Get the concurrency property: The max number of concurrent runs for the pipeline.
     * 
     * @return the concurrency value.
     */
    @Generated
    public Integer getConcurrency() {
        return this.concurrency;
    }

    /**
     * Set the concurrency property: The max number of concurrent runs for the pipeline.
     * 
     * @param concurrency the concurrency value to set.
     * @return the PipelineResource object itself.
     */
    @Generated
    public PipelineResource setConcurrency(Integer concurrency) {
        this.concurrency = concurrency;
        return this;
    }

    /**
     * Get the annotations property: List of tags that can be used for describing the Pipeline.
     * 
     * @return the annotations value.
     */
    @Generated
    public List<Object> getAnnotations() {
        return this.annotations;
    }

    /**
     * Set the annotations property: List of tags that can be used for describing the Pipeline.
     * 
     * @param annotations the annotations value to set.
     * @return the PipelineResource object itself.
     */
    @Generated
    public PipelineResource setAnnotations(List<Object> annotations) {
        this.annotations = annotations;
        return this;
    }

    /**
     * Get the runDimensions property: Dimensions emitted by Pipeline.
     * 
     * @return the runDimensions value.
     */
    @Generated
    public Map<String, Object> getRunDimensions() {
        return this.runDimensions;
    }

    /**
     * Set the runDimensions property: Dimensions emitted by Pipeline.
     * 
     * @param runDimensions the runDimensions value to set.
     * @return the PipelineResource object itself.
     */
    @Generated
    public PipelineResource setRunDimensions(Map<String, Object> runDimensions) {
        this.runDimensions = runDimensions;
        return this;
    }

    /**
     * Get the folder property: The folder that this Pipeline is in. If not specified, Pipeline will appear at the root
     * level.
     * 
     * @return the folder value.
     */
    @Generated
    public PipelineFolder getFolder() {
        return this.folder;
    }

    /**
     * Set the folder property: The folder that this Pipeline is in. If not specified, Pipeline will appear at the root
     * level.
     * 
     * @param folder the folder value to set.
     * @return the PipelineResource object itself.
     */
    @Generated
    public PipelineResource setFolder(PipelineFolder folder) {
        this.folder = folder;
        return this;
    }

    /**
     * Get the additionalProperties property: Pipeline resource type.
     * 
     * @return the additionalProperties value.
     */
    @Generated
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    /**
     * Set the additionalProperties property: Pipeline resource type.
     * 
     * @param additionalProperties the additionalProperties value to set.
     * @return the PipelineResource object itself.
     */
    @Generated
    public PipelineResource setAdditionalProperties(Map<String, Object> additionalProperties) {
        this.additionalProperties = additionalProperties;
        return this;
    }

    /**
     * Get the etag property: Resource Etag.
     * 
     * @return the etag value.
     */
    @Generated
    @Override
    public String getEtag() {
        return this.etag;
    }

    /**
     * Get the type property: The type of the resource. E.g. "Microsoft.Compute/virtualMachines" or
     * "Microsoft.Storage/storageAccounts".
     * 
     * @return the type value.
     */
    @Generated
    @Override
    public String getType() {
        return this.type;
    }

    /**
     * Get the name property: The name of the resource.
     * 
     * @return the name value.
     */
    @Generated
    @Override
    public String getName() {
        return this.name;
    }

    /**
     * Get the id property: Fully qualified resource ID for the resource. Ex -
     * /subscriptions/{subscriptionId}/resourceGroups/{resourceGroupName}/providers/{resourceProviderNamespace}/{resourceType}/{resourceName}.
     * 
     * @return the id value.
     */
    @Generated
    @Override
    public String getId() {
        return this.id;
    }

    /**
     * {@inheritDoc}
     */
    @Generated
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        if (description != null
            || activities != null
            || parameters != null
            || variables != null
            || concurrency != null
            || annotations != null
            || runDimensions != null
            || folder != null) {
            jsonWriter.writeStartObject("properties");
            jsonWriter.writeStringField("description", this.description);
            jsonWriter.writeArrayField("activities", this.activities, (writer, element) -> writer.writeJson(element));
            jsonWriter.writeMapField("parameters", this.parameters, (writer, element) -> writer.writeJson(element));
            jsonWriter.writeMapField("variables", this.variables, (writer, element) -> writer.writeJson(element));
            jsonWriter.writeNumberField("concurrency", this.concurrency);
            jsonWriter.writeArrayField("annotations", this.annotations,
                (writer, element) -> writer.writeUntyped(element));
            jsonWriter.writeMapField("runDimensions", this.runDimensions,
                (writer, element) -> writer.writeUntyped(element));
            jsonWriter.writeJsonField("folder", this.folder);
            jsonWriter.writeEndObject();
        }
        if (additionalProperties != null) {
            for (Map.Entry<String, Object> additionalProperty : additionalProperties.entrySet()) {
                jsonWriter.writeUntypedField(additionalProperty.getKey(), additionalProperty.getValue());
            }
        }
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of PipelineResource from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of PipelineResource if the JsonReader was pointing to an instance of it, or null if it was
     * pointing to JSON null.
     * @throws IOException If an error occurs while reading the PipelineResource.
     */
    @Generated
    public static PipelineResource fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            PipelineResource deserializedPipelineResource = new PipelineResource();
            Map<String, Object> additionalProperties = null;
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("id".equals(fieldName)) {
                    deserializedPipelineResource.id = reader.getString();
                } else if ("name".equals(fieldName)) {
                    deserializedPipelineResource.name = reader.getString();
                } else if ("type".equals(fieldName)) {
                    deserializedPipelineResource.type = reader.getString();
                } else if ("etag".equals(fieldName)) {
                    deserializedPipelineResource.etag = reader.getString();
                } else if ("properties".equals(fieldName) && reader.currentToken() == JsonToken.START_OBJECT) {
                    while (reader.nextToken() != JsonToken.END_OBJECT) {
                        fieldName = reader.getFieldName();
                        reader.nextToken();

                        if ("description".equals(fieldName)) {
                            deserializedPipelineResource.description = reader.getString();
                        } else if ("activities".equals(fieldName)) {
                            List<Activity> activities = reader.readArray(reader1 -> Activity.fromJson(reader1));
                            deserializedPipelineResource.activities = activities;
                        } else if ("parameters".equals(fieldName)) {
                            Map<String, ParameterSpecification> parameters
                                = reader.readMap(reader1 -> ParameterSpecification.fromJson(reader1));
                            deserializedPipelineResource.parameters = parameters;
                        } else if ("variables".equals(fieldName)) {
                            Map<String, VariableSpecification> variables
                                = reader.readMap(reader1 -> VariableSpecification.fromJson(reader1));
                            deserializedPipelineResource.variables = variables;
                        } else if ("concurrency".equals(fieldName)) {
                            deserializedPipelineResource.concurrency = reader.getNullable(JsonReader::getInt);
                        } else if ("annotations".equals(fieldName)) {
                            List<Object> annotations = reader.readArray(reader1 -> reader1.readUntyped());
                            deserializedPipelineResource.annotations = annotations;
                        } else if ("runDimensions".equals(fieldName)) {
                            Map<String, Object> runDimensions = reader.readMap(reader1 -> reader1.readUntyped());
                            deserializedPipelineResource.runDimensions = runDimensions;
                        } else if ("folder".equals(fieldName)) {
                            deserializedPipelineResource.folder = PipelineFolder.fromJson(reader);
                        } else {
                            if (additionalProperties == null) {
                                additionalProperties = new LinkedHashMap<>();
                            }

                            additionalProperties.put(fieldName, reader.readUntyped());
                        }
                    }
                } else {
                    if (additionalProperties == null) {
                        additionalProperties = new LinkedHashMap<>();
                    }

                    additionalProperties.put(fieldName, reader.readUntyped());
                }
            }
            deserializedPipelineResource.additionalProperties = additionalProperties;

            return deserializedPipelineResource;
        });
    }
}
