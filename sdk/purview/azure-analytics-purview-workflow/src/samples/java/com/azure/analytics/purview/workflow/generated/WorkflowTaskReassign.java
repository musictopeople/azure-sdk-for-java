// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.analytics.purview.workflow.generated;

import com.azure.analytics.purview.workflow.WorkflowTaskClient;
import com.azure.analytics.purview.workflow.WorkflowTaskClientBuilder;
import com.azure.core.http.rest.RequestOptions;
import com.azure.core.http.rest.Response;
import com.azure.core.util.BinaryData;
import com.azure.core.util.Configuration;
import com.azure.identity.DefaultAzureCredentialBuilder;

public class WorkflowTaskReassign {
    public static void main(String[] args) {
        WorkflowTaskClient workflowTaskClient
            = new WorkflowTaskClientBuilder().credential(new DefaultAzureCredentialBuilder().build())
                .endpoint(Configuration.getGlobalConfiguration().get("ENDPOINT"))
                .buildClient();
        // BEGIN:com.azure.analytics.purview.workflow.generated.workflow-task-reassign.workflow-task-reassign
        BinaryData reassignCommand = BinaryData.fromString(
            "{\"reassignments\":[{\"reassignFrom\":\"eece94d9-0619-4669-bb8a-d6ecec5220bc\",\"reassignTo\":\"7645223c-cdca-43e9-98c8-bd4d97e79e5e\"}]}");
        RequestOptions requestOptions = new RequestOptions();
        Response<Void> response = workflowTaskClient.reassignWithResponse("11b0244b-70ea-4c6b-9d28-08f52de40f2f",
            reassignCommand, requestOptions);
        // END:com.azure.analytics.purview.workflow.generated.workflow-task-reassign.workflow-task-reassign
    }
}
