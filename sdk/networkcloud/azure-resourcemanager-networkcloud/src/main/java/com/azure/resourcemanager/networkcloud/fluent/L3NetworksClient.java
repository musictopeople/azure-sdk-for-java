// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.networkcloud.fluent;

import com.azure.core.annotation.ReturnType;
import com.azure.core.annotation.ServiceMethod;
import com.azure.core.http.rest.PagedIterable;
import com.azure.core.http.rest.Response;
import com.azure.core.management.polling.PollResult;
import com.azure.core.util.Context;
import com.azure.core.util.polling.SyncPoller;
import com.azure.resourcemanager.networkcloud.fluent.models.L3NetworkInner;
import com.azure.resourcemanager.networkcloud.fluent.models.OperationStatusResultInner;
import com.azure.resourcemanager.networkcloud.models.L3NetworkPatchParameters;

/**
 * An instance of this class provides access to all the operations defined in L3NetworksClient.
 */
public interface L3NetworksClient {
    /**
     * List layer 3 (L3) networks in the subscription.
     * 
     * Get a list of layer 3 (L3) networks in the provided subscription.
     * 
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a list of layer 3 (L3) networks in the provided subscription as paginated response with
     * {@link PagedIterable}.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    PagedIterable<L3NetworkInner> list();

    /**
     * List layer 3 (L3) networks in the subscription.
     * 
     * Get a list of layer 3 (L3) networks in the provided subscription.
     * 
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a list of layer 3 (L3) networks in the provided subscription as paginated response with
     * {@link PagedIterable}.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    PagedIterable<L3NetworkInner> list(Context context);

    /**
     * List layer 3 (L3) networks in the resource group.
     * 
     * Get a list of layer 3 (L3) networks in the provided resource group.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a list of layer 3 (L3) networks in the provided resource group as paginated response with
     * {@link PagedIterable}.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    PagedIterable<L3NetworkInner> listByResourceGroup(String resourceGroupName);

    /**
     * List layer 3 (L3) networks in the resource group.
     * 
     * Get a list of layer 3 (L3) networks in the provided resource group.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a list of layer 3 (L3) networks in the provided resource group as paginated response with
     * {@link PagedIterable}.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    PagedIterable<L3NetworkInner> listByResourceGroup(String resourceGroupName, Context context);

    /**
     * Retrieve the layer 3 (L3) network.
     * 
     * Get properties of the provided layer 3 (L3) network.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param l3NetworkName The name of the L3 network.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return properties of the provided layer 3 (L3) network along with {@link Response}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Response<L3NetworkInner> getByResourceGroupWithResponse(String resourceGroupName, String l3NetworkName,
        Context context);

    /**
     * Retrieve the layer 3 (L3) network.
     * 
     * Get properties of the provided layer 3 (L3) network.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param l3NetworkName The name of the L3 network.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return properties of the provided layer 3 (L3) network.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    L3NetworkInner getByResourceGroup(String resourceGroupName, String l3NetworkName);

    /**
     * Create or update the layer 3 (L3) network.
     * 
     * Create a new layer 3 (L3) network or update the properties of the existing network.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param l3NetworkName The name of the L3 network.
     * @param l3NetworkParameters The request body.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the {@link SyncPoller} for polling of l3Network represents a network that utilizes a single isolation
     * domain set up for layer-3 resources.
     */
    @ServiceMethod(returns = ReturnType.LONG_RUNNING_OPERATION)
    SyncPoller<PollResult<L3NetworkInner>, L3NetworkInner> beginCreateOrUpdate(String resourceGroupName,
        String l3NetworkName, L3NetworkInner l3NetworkParameters);

    /**
     * Create or update the layer 3 (L3) network.
     * 
     * Create a new layer 3 (L3) network or update the properties of the existing network.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param l3NetworkName The name of the L3 network.
     * @param l3NetworkParameters The request body.
     * @param ifMatch The ETag of the transformation. Omit this value to always overwrite the current resource. Specify
     * the last-seen ETag value to prevent accidentally overwriting concurrent changes.
     * @param ifNoneMatch Set to '*' to allow a new record set to be created, but to prevent updating an existing
     * resource. Other values will result in error from server as they are not supported.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the {@link SyncPoller} for polling of l3Network represents a network that utilizes a single isolation
     * domain set up for layer-3 resources.
     */
    @ServiceMethod(returns = ReturnType.LONG_RUNNING_OPERATION)
    SyncPoller<PollResult<L3NetworkInner>, L3NetworkInner> beginCreateOrUpdate(String resourceGroupName,
        String l3NetworkName, L3NetworkInner l3NetworkParameters, String ifMatch, String ifNoneMatch, Context context);

    /**
     * Create or update the layer 3 (L3) network.
     * 
     * Create a new layer 3 (L3) network or update the properties of the existing network.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param l3NetworkName The name of the L3 network.
     * @param l3NetworkParameters The request body.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return l3Network represents a network that utilizes a single isolation domain set up for layer-3 resources.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    L3NetworkInner createOrUpdate(String resourceGroupName, String l3NetworkName, L3NetworkInner l3NetworkParameters);

    /**
     * Create or update the layer 3 (L3) network.
     * 
     * Create a new layer 3 (L3) network or update the properties of the existing network.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param l3NetworkName The name of the L3 network.
     * @param l3NetworkParameters The request body.
     * @param ifMatch The ETag of the transformation. Omit this value to always overwrite the current resource. Specify
     * the last-seen ETag value to prevent accidentally overwriting concurrent changes.
     * @param ifNoneMatch Set to '*' to allow a new record set to be created, but to prevent updating an existing
     * resource. Other values will result in error from server as they are not supported.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return l3Network represents a network that utilizes a single isolation domain set up for layer-3 resources.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    L3NetworkInner createOrUpdate(String resourceGroupName, String l3NetworkName, L3NetworkInner l3NetworkParameters,
        String ifMatch, String ifNoneMatch, Context context);

    /**
     * Delete the layer 3 (L3) network.
     * 
     * Delete the provided layer 3 (L3) network.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param l3NetworkName The name of the L3 network.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the {@link SyncPoller} for polling of the current status of an async operation.
     */
    @ServiceMethod(returns = ReturnType.LONG_RUNNING_OPERATION)
    SyncPoller<PollResult<OperationStatusResultInner>, OperationStatusResultInner> beginDelete(String resourceGroupName,
        String l3NetworkName);

    /**
     * Delete the layer 3 (L3) network.
     * 
     * Delete the provided layer 3 (L3) network.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param l3NetworkName The name of the L3 network.
     * @param ifMatch The ETag of the transformation. Omit this value to always overwrite the current resource. Specify
     * the last-seen ETag value to prevent accidentally overwriting concurrent changes.
     * @param ifNoneMatch Set to '*' to allow a new record set to be created, but to prevent updating an existing
     * resource. Other values will result in error from server as they are not supported.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the {@link SyncPoller} for polling of the current status of an async operation.
     */
    @ServiceMethod(returns = ReturnType.LONG_RUNNING_OPERATION)
    SyncPoller<PollResult<OperationStatusResultInner>, OperationStatusResultInner> beginDelete(String resourceGroupName,
        String l3NetworkName, String ifMatch, String ifNoneMatch, Context context);

    /**
     * Delete the layer 3 (L3) network.
     * 
     * Delete the provided layer 3 (L3) network.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param l3NetworkName The name of the L3 network.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the current status of an async operation.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    OperationStatusResultInner delete(String resourceGroupName, String l3NetworkName);

    /**
     * Delete the layer 3 (L3) network.
     * 
     * Delete the provided layer 3 (L3) network.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param l3NetworkName The name of the L3 network.
     * @param ifMatch The ETag of the transformation. Omit this value to always overwrite the current resource. Specify
     * the last-seen ETag value to prevent accidentally overwriting concurrent changes.
     * @param ifNoneMatch Set to '*' to allow a new record set to be created, but to prevent updating an existing
     * resource. Other values will result in error from server as they are not supported.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the current status of an async operation.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    OperationStatusResultInner delete(String resourceGroupName, String l3NetworkName, String ifMatch,
        String ifNoneMatch, Context context);

    /**
     * Patch the layer 3 (L3) network.
     * 
     * Update tags associated with the provided layer 3 (L3) network.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param l3NetworkName The name of the L3 network.
     * @param ifMatch The ETag of the transformation. Omit this value to always overwrite the current resource. Specify
     * the last-seen ETag value to prevent accidentally overwriting concurrent changes.
     * @param ifNoneMatch Set to '*' to allow a new record set to be created, but to prevent updating an existing
     * resource. Other values will result in error from server as they are not supported.
     * @param l3NetworkUpdateParameters The request body.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return l3Network represents a network that utilizes a single isolation domain set up for layer-3 resources along
     * with {@link Response}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Response<L3NetworkInner> updateWithResponse(String resourceGroupName, String l3NetworkName, String ifMatch,
        String ifNoneMatch, L3NetworkPatchParameters l3NetworkUpdateParameters, Context context);

    /**
     * Patch the layer 3 (L3) network.
     * 
     * Update tags associated with the provided layer 3 (L3) network.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param l3NetworkName The name of the L3 network.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return l3Network represents a network that utilizes a single isolation domain set up for layer-3 resources.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    L3NetworkInner update(String resourceGroupName, String l3NetworkName);
}
