// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.ai.metricsadvisor.implementation.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.annotation.Generated;
import com.azure.core.util.CoreUtils;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

/**
 * The MetricDataQueryOptions model.
 */
@Fluent
public final class MetricDataQueryOptions implements JsonSerializable<MetricDataQueryOptions> {
    /*
     * start time of query a time series data, and format should be yyyy-MM-ddThh:mm:ssZ. The maximum number of data
     * points (series number * time range) is 10000.
     */
    @Generated
    private OffsetDateTime startTime;

    /*
     * start time of query a time series data, and format should be yyyy-MM-ddThh:mm:ssZ. The maximum number of data
     * points (series number * time range) is 10000.
     */
    @Generated
    private OffsetDateTime endTime;

    /*
     * query specific series. The maximum number of series is 100.
     */
    @Generated
    private List<Map<String, String>> series;

    /**
     * Creates an instance of MetricDataQueryOptions class.
     */
    @Generated
    public MetricDataQueryOptions() {
    }

    /**
     * Get the startTime property: start time of query a time series data, and format should be yyyy-MM-ddThh:mm:ssZ.
     * The maximum number of data points (series number * time range) is 10000.
     * 
     * @return the startTime value.
     */
    @Generated
    public OffsetDateTime getStartTime() {
        return this.startTime;
    }

    /**
     * Set the startTime property: start time of query a time series data, and format should be yyyy-MM-ddThh:mm:ssZ.
     * The maximum number of data points (series number * time range) is 10000.
     * 
     * @param startTime the startTime value to set.
     * @return the MetricDataQueryOptions object itself.
     */
    @Generated
    public MetricDataQueryOptions setStartTime(OffsetDateTime startTime) {
        this.startTime = startTime;
        return this;
    }

    /**
     * Get the endTime property: start time of query a time series data, and format should be yyyy-MM-ddThh:mm:ssZ. The
     * maximum number of data points (series number * time range) is 10000.
     * 
     * @return the endTime value.
     */
    @Generated
    public OffsetDateTime getEndTime() {
        return this.endTime;
    }

    /**
     * Set the endTime property: start time of query a time series data, and format should be yyyy-MM-ddThh:mm:ssZ. The
     * maximum number of data points (series number * time range) is 10000.
     * 
     * @param endTime the endTime value to set.
     * @return the MetricDataQueryOptions object itself.
     */
    @Generated
    public MetricDataQueryOptions setEndTime(OffsetDateTime endTime) {
        this.endTime = endTime;
        return this;
    }

    /**
     * Get the series property: query specific series. The maximum number of series is 100.
     * 
     * @return the series value.
     */
    @Generated
    public List<Map<String, String>> getSeries() {
        return this.series;
    }

    /**
     * Set the series property: query specific series. The maximum number of series is 100.
     * 
     * @param series the series value to set.
     * @return the MetricDataQueryOptions object itself.
     */
    @Generated
    public MetricDataQueryOptions setSeries(List<Map<String, String>> series) {
        this.series = series;
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Generated
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeStringField("startTime",
            this.startTime == null ? null : DateTimeFormatter.ISO_OFFSET_DATE_TIME.format(this.startTime));
        jsonWriter.writeStringField("endTime",
            this.endTime == null ? null : DateTimeFormatter.ISO_OFFSET_DATE_TIME.format(this.endTime));
        jsonWriter.writeArrayField("series", this.series,
            (writer, element) -> writer.writeMap(element, (writer1, element1) -> writer1.writeString(element1)));
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of MetricDataQueryOptions from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of MetricDataQueryOptions if the JsonReader was pointing to an instance of it, or null if it
     * was pointing to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the MetricDataQueryOptions.
     */
    @Generated
    public static MetricDataQueryOptions fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            MetricDataQueryOptions deserializedMetricDataQueryOptions = new MetricDataQueryOptions();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("startTime".equals(fieldName)) {
                    deserializedMetricDataQueryOptions.startTime = reader
                        .getNullable(nonNullReader -> CoreUtils.parseBestOffsetDateTime(nonNullReader.getString()));
                } else if ("endTime".equals(fieldName)) {
                    deserializedMetricDataQueryOptions.endTime = reader
                        .getNullable(nonNullReader -> CoreUtils.parseBestOffsetDateTime(nonNullReader.getString()));
                } else if ("series".equals(fieldName)) {
                    List<Map<String, String>> series
                        = reader.readArray(reader1 -> reader1.readMap(reader2 -> reader2.getString()));
                    deserializedMetricDataQueryOptions.series = series;
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedMetricDataQueryOptions;
        });
    }
}
