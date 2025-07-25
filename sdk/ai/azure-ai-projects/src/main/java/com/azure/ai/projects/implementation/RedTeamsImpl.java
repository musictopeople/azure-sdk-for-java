// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.

package com.azure.ai.projects.implementation;

import com.azure.ai.projects.ProjectsServiceVersion;
import com.azure.core.annotation.BodyParam;
import com.azure.core.annotation.ExpectedResponses;
import com.azure.core.annotation.Get;
import com.azure.core.annotation.HeaderParam;
import com.azure.core.annotation.Host;
import com.azure.core.annotation.HostParam;
import com.azure.core.annotation.PathParam;
import com.azure.core.annotation.Post;
import com.azure.core.annotation.QueryParam;
import com.azure.core.annotation.ReturnType;
import com.azure.core.annotation.ServiceInterface;
import com.azure.core.annotation.ServiceMethod;
import com.azure.core.annotation.UnexpectedResponseExceptionType;
import com.azure.core.exception.ClientAuthenticationException;
import com.azure.core.exception.HttpResponseException;
import com.azure.core.exception.ResourceModifiedException;
import com.azure.core.exception.ResourceNotFoundException;
import com.azure.core.http.rest.PagedFlux;
import com.azure.core.http.rest.PagedIterable;
import com.azure.core.http.rest.PagedResponse;
import com.azure.core.http.rest.PagedResponseBase;
import com.azure.core.http.rest.RequestOptions;
import com.azure.core.http.rest.Response;
import com.azure.core.http.rest.RestProxy;
import com.azure.core.util.BinaryData;
import com.azure.core.util.Context;
import com.azure.core.util.FluxUtil;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import reactor.core.publisher.Mono;

/**
 * An instance of this class provides access to all the operations defined in RedTeams.
 */
public final class RedTeamsImpl {
    /**
     * The proxy service used to perform REST calls.
     */
    private final RedTeamsService service;

    /**
     * The service client containing this operation class.
     */
    private final AIProjectClientImpl client;

    /**
     * Initializes an instance of RedTeamsImpl.
     * 
     * @param client the instance of the service client containing this operation class.
     */
    RedTeamsImpl(AIProjectClientImpl client) {
        this.service = RestProxy.create(RedTeamsService.class, client.getHttpPipeline(), client.getSerializerAdapter());
        this.client = client;
    }

    /**
     * Gets Service version.
     * 
     * @return the serviceVersion value.
     */
    public ProjectsServiceVersion getServiceVersion() {
        return client.getServiceVersion();
    }

    /**
     * The interface defining all the services for AIProjectClientRedTeams to be used by the proxy service to perform
     * REST calls.
     */
    @Host("{endpoint}")
    @ServiceInterface(name = "AIProjectClientRedTeams")
    public interface RedTeamsService {
        @Get("/redTeams/runs/{name}")
        @ExpectedResponses({ 200 })
        @UnexpectedResponseExceptionType(value = ClientAuthenticationException.class, code = { 401 })
        @UnexpectedResponseExceptionType(value = ResourceNotFoundException.class, code = { 404 })
        @UnexpectedResponseExceptionType(value = ResourceModifiedException.class, code = { 409 })
        @UnexpectedResponseExceptionType(HttpResponseException.class)
        Mono<Response<BinaryData>> getRedTeam(@HostParam("endpoint") String endpoint,
            @QueryParam("api-version") String apiVersion, @PathParam("name") String name,
            @HeaderParam("Accept") String accept, RequestOptions requestOptions, Context context);

        @Get("/redTeams/runs/{name}")
        @ExpectedResponses({ 200 })
        @UnexpectedResponseExceptionType(value = ClientAuthenticationException.class, code = { 401 })
        @UnexpectedResponseExceptionType(value = ResourceNotFoundException.class, code = { 404 })
        @UnexpectedResponseExceptionType(value = ResourceModifiedException.class, code = { 409 })
        @UnexpectedResponseExceptionType(HttpResponseException.class)
        Response<BinaryData> getRedTeamSync(@HostParam("endpoint") String endpoint,
            @QueryParam("api-version") String apiVersion, @PathParam("name") String name,
            @HeaderParam("Accept") String accept, RequestOptions requestOptions, Context context);

        @Get("/redTeams/runs")
        @ExpectedResponses({ 200 })
        @UnexpectedResponseExceptionType(value = ClientAuthenticationException.class, code = { 401 })
        @UnexpectedResponseExceptionType(value = ResourceNotFoundException.class, code = { 404 })
        @UnexpectedResponseExceptionType(value = ResourceModifiedException.class, code = { 409 })
        @UnexpectedResponseExceptionType(HttpResponseException.class)
        Mono<Response<BinaryData>> listRedTeams(@HostParam("endpoint") String endpoint,
            @QueryParam("api-version") String apiVersion, @HeaderParam("Accept") String accept,
            RequestOptions requestOptions, Context context);

        @Get("/redTeams/runs")
        @ExpectedResponses({ 200 })
        @UnexpectedResponseExceptionType(value = ClientAuthenticationException.class, code = { 401 })
        @UnexpectedResponseExceptionType(value = ResourceNotFoundException.class, code = { 404 })
        @UnexpectedResponseExceptionType(value = ResourceModifiedException.class, code = { 409 })
        @UnexpectedResponseExceptionType(HttpResponseException.class)
        Response<BinaryData> listRedTeamsSync(@HostParam("endpoint") String endpoint,
            @QueryParam("api-version") String apiVersion, @HeaderParam("Accept") String accept,
            RequestOptions requestOptions, Context context);

        @Post("/redTeams/runs:run")
        @ExpectedResponses({ 201 })
        @UnexpectedResponseExceptionType(value = ClientAuthenticationException.class, code = { 401 })
        @UnexpectedResponseExceptionType(value = ResourceNotFoundException.class, code = { 404 })
        @UnexpectedResponseExceptionType(value = ResourceModifiedException.class, code = { 409 })
        @UnexpectedResponseExceptionType(HttpResponseException.class)
        Mono<Response<BinaryData>> createRedTeam(@HostParam("endpoint") String endpoint,
            @QueryParam("api-version") String apiVersion, @HeaderParam("Content-Type") String contentType,
            @HeaderParam("Accept") String accept, @BodyParam("application/json") BinaryData redTeam,
            RequestOptions requestOptions, Context context);

        @Post("/redTeams/runs:run")
        @ExpectedResponses({ 201 })
        @UnexpectedResponseExceptionType(value = ClientAuthenticationException.class, code = { 401 })
        @UnexpectedResponseExceptionType(value = ResourceNotFoundException.class, code = { 404 })
        @UnexpectedResponseExceptionType(value = ResourceModifiedException.class, code = { 409 })
        @UnexpectedResponseExceptionType(HttpResponseException.class)
        Response<BinaryData> createRedTeamSync(@HostParam("endpoint") String endpoint,
            @QueryParam("api-version") String apiVersion, @HeaderParam("Content-Type") String contentType,
            @HeaderParam("Accept") String accept, @BodyParam("application/json") BinaryData redTeam,
            RequestOptions requestOptions, Context context);

        @Get("{nextLink}")
        @ExpectedResponses({ 200 })
        @UnexpectedResponseExceptionType(value = ClientAuthenticationException.class, code = { 401 })
        @UnexpectedResponseExceptionType(value = ResourceNotFoundException.class, code = { 404 })
        @UnexpectedResponseExceptionType(value = ResourceModifiedException.class, code = { 409 })
        @UnexpectedResponseExceptionType(HttpResponseException.class)
        Mono<Response<BinaryData>> listRedTeamsNext(@PathParam(value = "nextLink", encoded = true) String nextLink,
            @HostParam("endpoint") String endpoint, @HeaderParam("Accept") String accept, RequestOptions requestOptions,
            Context context);

        @Get("{nextLink}")
        @ExpectedResponses({ 200 })
        @UnexpectedResponseExceptionType(value = ClientAuthenticationException.class, code = { 401 })
        @UnexpectedResponseExceptionType(value = ResourceNotFoundException.class, code = { 404 })
        @UnexpectedResponseExceptionType(value = ResourceModifiedException.class, code = { 409 })
        @UnexpectedResponseExceptionType(HttpResponseException.class)
        Response<BinaryData> listRedTeamsNextSync(@PathParam(value = "nextLink", encoded = true) String nextLink,
            @HostParam("endpoint") String endpoint, @HeaderParam("Accept") String accept, RequestOptions requestOptions,
            Context context);
    }

    /**
     * Get a redteam by name.
     * <p><strong>Response Body Schema</strong></p>
     * 
     * <pre>
     * {@code
     * {
     *     id: String (Required)
     *     displayName: String (Optional)
     *     numTurns: Integer (Optional)
     *     attackStrategies (Optional): [
     *         String(easy/moderate/difficult/ascii_art/ascii_smuggler/atbash/base64/binary/caesar/character_space/jailbreak/ansii_attack/character_swap/suffix_append/string_join/unicode_confusable/unicode_substitution/diacritic/flip/leetspeak/rot13/morse/url/baseline) (Optional)
     *     ]
     *     simulationOnly: Boolean (Optional)
     *     riskCategories (Optional): [
     *         String(HateUnfairness/Violence/Sexual/SelfHarm) (Optional)
     *     ]
     *     applicationScenario: String (Optional)
     *     tags (Optional): {
     *         String: String (Required)
     *     }
     *     properties (Optional): {
     *         String: String (Required)
     *     }
     *     status: String (Optional)
     *     target (Required): {
     *         type: String (Required)
     *     }
     * }
     * }
     * </pre>
     * 
     * @param name Identifier of the red team run.
     * @param requestOptions The options to configure the HTTP request before HTTP client sends it.
     * @throws HttpResponseException thrown if the request is rejected by server.
     * @throws ClientAuthenticationException thrown if the request is rejected by server on status code 401.
     * @throws ResourceNotFoundException thrown if the request is rejected by server on status code 404.
     * @throws ResourceModifiedException thrown if the request is rejected by server on status code 409.
     * @return a redteam by name along with {@link Response} on successful completion of {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<BinaryData>> getRedTeamWithResponseAsync(String name, RequestOptions requestOptions) {
        final String accept = "application/json";
        return FluxUtil.withContext(context -> service.getRedTeam(this.client.getEndpoint(),
            this.client.getServiceVersion().getVersion(), name, accept, requestOptions, context));
    }

    /**
     * Get a redteam by name.
     * <p><strong>Response Body Schema</strong></p>
     * 
     * <pre>
     * {@code
     * {
     *     id: String (Required)
     *     displayName: String (Optional)
     *     numTurns: Integer (Optional)
     *     attackStrategies (Optional): [
     *         String(easy/moderate/difficult/ascii_art/ascii_smuggler/atbash/base64/binary/caesar/character_space/jailbreak/ansii_attack/character_swap/suffix_append/string_join/unicode_confusable/unicode_substitution/diacritic/flip/leetspeak/rot13/morse/url/baseline) (Optional)
     *     ]
     *     simulationOnly: Boolean (Optional)
     *     riskCategories (Optional): [
     *         String(HateUnfairness/Violence/Sexual/SelfHarm) (Optional)
     *     ]
     *     applicationScenario: String (Optional)
     *     tags (Optional): {
     *         String: String (Required)
     *     }
     *     properties (Optional): {
     *         String: String (Required)
     *     }
     *     status: String (Optional)
     *     target (Required): {
     *         type: String (Required)
     *     }
     * }
     * }
     * </pre>
     * 
     * @param name Identifier of the red team run.
     * @param requestOptions The options to configure the HTTP request before HTTP client sends it.
     * @throws HttpResponseException thrown if the request is rejected by server.
     * @throws ClientAuthenticationException thrown if the request is rejected by server on status code 401.
     * @throws ResourceNotFoundException thrown if the request is rejected by server on status code 404.
     * @throws ResourceModifiedException thrown if the request is rejected by server on status code 409.
     * @return a redteam by name along with {@link Response}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<BinaryData> getRedTeamWithResponse(String name, RequestOptions requestOptions) {
        final String accept = "application/json";
        return service.getRedTeamSync(this.client.getEndpoint(), this.client.getServiceVersion().getVersion(), name,
            accept, requestOptions, Context.NONE);
    }

    /**
     * List a redteam by name.
     * <p><strong>Response Body Schema</strong></p>
     * 
     * <pre>
     * {@code
     * {
     *     id: String (Required)
     *     displayName: String (Optional)
     *     numTurns: Integer (Optional)
     *     attackStrategies (Optional): [
     *         String(easy/moderate/difficult/ascii_art/ascii_smuggler/atbash/base64/binary/caesar/character_space/jailbreak/ansii_attack/character_swap/suffix_append/string_join/unicode_confusable/unicode_substitution/diacritic/flip/leetspeak/rot13/morse/url/baseline) (Optional)
     *     ]
     *     simulationOnly: Boolean (Optional)
     *     riskCategories (Optional): [
     *         String(HateUnfairness/Violence/Sexual/SelfHarm) (Optional)
     *     ]
     *     applicationScenario: String (Optional)
     *     tags (Optional): {
     *         String: String (Required)
     *     }
     *     properties (Optional): {
     *         String: String (Required)
     *     }
     *     status: String (Optional)
     *     target (Required): {
     *         type: String (Required)
     *     }
     * }
     * }
     * </pre>
     * 
     * @param requestOptions The options to configure the HTTP request before HTTP client sends it.
     * @throws HttpResponseException thrown if the request is rejected by server.
     * @throws ClientAuthenticationException thrown if the request is rejected by server on status code 401.
     * @throws ResourceNotFoundException thrown if the request is rejected by server on status code 404.
     * @throws ResourceModifiedException thrown if the request is rejected by server on status code 409.
     * @return paged collection of RedTeam items along with {@link PagedResponse} on successful completion of
     * {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    private Mono<PagedResponse<BinaryData>> listRedTeamsSinglePageAsync(RequestOptions requestOptions) {
        final String accept = "application/json";
        return FluxUtil
            .withContext(context -> service.listRedTeams(this.client.getEndpoint(),
                this.client.getServiceVersion().getVersion(), accept, requestOptions, context))
            .map(res -> new PagedResponseBase<>(res.getRequest(), res.getStatusCode(), res.getHeaders(),
                getValues(res.getValue(), "value"), getNextLink(res.getValue(), "nextLink"), null));
    }

    /**
     * List a redteam by name.
     * <p><strong>Response Body Schema</strong></p>
     * 
     * <pre>
     * {@code
     * {
     *     id: String (Required)
     *     displayName: String (Optional)
     *     numTurns: Integer (Optional)
     *     attackStrategies (Optional): [
     *         String(easy/moderate/difficult/ascii_art/ascii_smuggler/atbash/base64/binary/caesar/character_space/jailbreak/ansii_attack/character_swap/suffix_append/string_join/unicode_confusable/unicode_substitution/diacritic/flip/leetspeak/rot13/morse/url/baseline) (Optional)
     *     ]
     *     simulationOnly: Boolean (Optional)
     *     riskCategories (Optional): [
     *         String(HateUnfairness/Violence/Sexual/SelfHarm) (Optional)
     *     ]
     *     applicationScenario: String (Optional)
     *     tags (Optional): {
     *         String: String (Required)
     *     }
     *     properties (Optional): {
     *         String: String (Required)
     *     }
     *     status: String (Optional)
     *     target (Required): {
     *         type: String (Required)
     *     }
     * }
     * }
     * </pre>
     * 
     * @param requestOptions The options to configure the HTTP request before HTTP client sends it.
     * @throws HttpResponseException thrown if the request is rejected by server.
     * @throws ClientAuthenticationException thrown if the request is rejected by server on status code 401.
     * @throws ResourceNotFoundException thrown if the request is rejected by server on status code 404.
     * @throws ResourceModifiedException thrown if the request is rejected by server on status code 409.
     * @return paged collection of RedTeam items as paginated response with {@link PagedFlux}.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    public PagedFlux<BinaryData> listRedTeamsAsync(RequestOptions requestOptions) {
        RequestOptions requestOptionsForNextPage = new RequestOptions();
        requestOptionsForNextPage.setContext(
            requestOptions != null && requestOptions.getContext() != null ? requestOptions.getContext() : Context.NONE);
        return new PagedFlux<>(() -> listRedTeamsSinglePageAsync(requestOptions),
            nextLink -> listRedTeamsNextSinglePageAsync(nextLink, requestOptionsForNextPage));
    }

    /**
     * List a redteam by name.
     * <p><strong>Response Body Schema</strong></p>
     * 
     * <pre>
     * {@code
     * {
     *     id: String (Required)
     *     displayName: String (Optional)
     *     numTurns: Integer (Optional)
     *     attackStrategies (Optional): [
     *         String(easy/moderate/difficult/ascii_art/ascii_smuggler/atbash/base64/binary/caesar/character_space/jailbreak/ansii_attack/character_swap/suffix_append/string_join/unicode_confusable/unicode_substitution/diacritic/flip/leetspeak/rot13/morse/url/baseline) (Optional)
     *     ]
     *     simulationOnly: Boolean (Optional)
     *     riskCategories (Optional): [
     *         String(HateUnfairness/Violence/Sexual/SelfHarm) (Optional)
     *     ]
     *     applicationScenario: String (Optional)
     *     tags (Optional): {
     *         String: String (Required)
     *     }
     *     properties (Optional): {
     *         String: String (Required)
     *     }
     *     status: String (Optional)
     *     target (Required): {
     *         type: String (Required)
     *     }
     * }
     * }
     * </pre>
     * 
     * @param requestOptions The options to configure the HTTP request before HTTP client sends it.
     * @throws HttpResponseException thrown if the request is rejected by server.
     * @throws ClientAuthenticationException thrown if the request is rejected by server on status code 401.
     * @throws ResourceNotFoundException thrown if the request is rejected by server on status code 404.
     * @throws ResourceModifiedException thrown if the request is rejected by server on status code 409.
     * @return paged collection of RedTeam items along with {@link PagedResponse}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    private PagedResponse<BinaryData> listRedTeamsSinglePage(RequestOptions requestOptions) {
        final String accept = "application/json";
        Response<BinaryData> res = service.listRedTeamsSync(this.client.getEndpoint(),
            this.client.getServiceVersion().getVersion(), accept, requestOptions, Context.NONE);
        return new PagedResponseBase<>(res.getRequest(), res.getStatusCode(), res.getHeaders(),
            getValues(res.getValue(), "value"), getNextLink(res.getValue(), "nextLink"), null);
    }

    /**
     * List a redteam by name.
     * <p><strong>Response Body Schema</strong></p>
     * 
     * <pre>
     * {@code
     * {
     *     id: String (Required)
     *     displayName: String (Optional)
     *     numTurns: Integer (Optional)
     *     attackStrategies (Optional): [
     *         String(easy/moderate/difficult/ascii_art/ascii_smuggler/atbash/base64/binary/caesar/character_space/jailbreak/ansii_attack/character_swap/suffix_append/string_join/unicode_confusable/unicode_substitution/diacritic/flip/leetspeak/rot13/morse/url/baseline) (Optional)
     *     ]
     *     simulationOnly: Boolean (Optional)
     *     riskCategories (Optional): [
     *         String(HateUnfairness/Violence/Sexual/SelfHarm) (Optional)
     *     ]
     *     applicationScenario: String (Optional)
     *     tags (Optional): {
     *         String: String (Required)
     *     }
     *     properties (Optional): {
     *         String: String (Required)
     *     }
     *     status: String (Optional)
     *     target (Required): {
     *         type: String (Required)
     *     }
     * }
     * }
     * </pre>
     * 
     * @param requestOptions The options to configure the HTTP request before HTTP client sends it.
     * @throws HttpResponseException thrown if the request is rejected by server.
     * @throws ClientAuthenticationException thrown if the request is rejected by server on status code 401.
     * @throws ResourceNotFoundException thrown if the request is rejected by server on status code 404.
     * @throws ResourceModifiedException thrown if the request is rejected by server on status code 409.
     * @return paged collection of RedTeam items as paginated response with {@link PagedIterable}.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    public PagedIterable<BinaryData> listRedTeams(RequestOptions requestOptions) {
        RequestOptions requestOptionsForNextPage = new RequestOptions();
        requestOptionsForNextPage.setContext(
            requestOptions != null && requestOptions.getContext() != null ? requestOptions.getContext() : Context.NONE);
        return new PagedIterable<>(() -> listRedTeamsSinglePage(requestOptions),
            nextLink -> listRedTeamsNextSinglePage(nextLink, requestOptionsForNextPage));
    }

    /**
     * Creates a redteam run.
     * <p><strong>Request Body Schema</strong></p>
     * 
     * <pre>
     * {@code
     * {
     *     id: String (Required)
     *     displayName: String (Optional)
     *     numTurns: Integer (Optional)
     *     attackStrategies (Optional): [
     *         String(easy/moderate/difficult/ascii_art/ascii_smuggler/atbash/base64/binary/caesar/character_space/jailbreak/ansii_attack/character_swap/suffix_append/string_join/unicode_confusable/unicode_substitution/diacritic/flip/leetspeak/rot13/morse/url/baseline) (Optional)
     *     ]
     *     simulationOnly: Boolean (Optional)
     *     riskCategories (Optional): [
     *         String(HateUnfairness/Violence/Sexual/SelfHarm) (Optional)
     *     ]
     *     applicationScenario: String (Optional)
     *     tags (Optional): {
     *         String: String (Required)
     *     }
     *     properties (Optional): {
     *         String: String (Required)
     *     }
     *     status: String (Optional)
     *     target (Required): {
     *         type: String (Required)
     *     }
     * }
     * }
     * </pre>
     * 
     * <p><strong>Response Body Schema</strong></p>
     * 
     * <pre>
     * {@code
     * {
     *     id: String (Required)
     *     displayName: String (Optional)
     *     numTurns: Integer (Optional)
     *     attackStrategies (Optional): [
     *         String(easy/moderate/difficult/ascii_art/ascii_smuggler/atbash/base64/binary/caesar/character_space/jailbreak/ansii_attack/character_swap/suffix_append/string_join/unicode_confusable/unicode_substitution/diacritic/flip/leetspeak/rot13/morse/url/baseline) (Optional)
     *     ]
     *     simulationOnly: Boolean (Optional)
     *     riskCategories (Optional): [
     *         String(HateUnfairness/Violence/Sexual/SelfHarm) (Optional)
     *     ]
     *     applicationScenario: String (Optional)
     *     tags (Optional): {
     *         String: String (Required)
     *     }
     *     properties (Optional): {
     *         String: String (Required)
     *     }
     *     status: String (Optional)
     *     target (Required): {
     *         type: String (Required)
     *     }
     * }
     * }
     * </pre>
     * 
     * @param redTeam Redteam to be run.
     * @param requestOptions The options to configure the HTTP request before HTTP client sends it.
     * @throws HttpResponseException thrown if the request is rejected by server.
     * @throws ClientAuthenticationException thrown if the request is rejected by server on status code 401.
     * @throws ResourceNotFoundException thrown if the request is rejected by server on status code 404.
     * @throws ResourceModifiedException thrown if the request is rejected by server on status code 409.
     * @return red team details along with {@link Response} on successful completion of {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<BinaryData>> createRedTeamWithResponseAsync(BinaryData redTeam,
        RequestOptions requestOptions) {
        final String contentType = "application/json";
        final String accept = "application/json";
        return FluxUtil.withContext(context -> service.createRedTeam(this.client.getEndpoint(),
            this.client.getServiceVersion().getVersion(), contentType, accept, redTeam, requestOptions, context));
    }

    /**
     * Creates a redteam run.
     * <p><strong>Request Body Schema</strong></p>
     * 
     * <pre>
     * {@code
     * {
     *     id: String (Required)
     *     displayName: String (Optional)
     *     numTurns: Integer (Optional)
     *     attackStrategies (Optional): [
     *         String(easy/moderate/difficult/ascii_art/ascii_smuggler/atbash/base64/binary/caesar/character_space/jailbreak/ansii_attack/character_swap/suffix_append/string_join/unicode_confusable/unicode_substitution/diacritic/flip/leetspeak/rot13/morse/url/baseline) (Optional)
     *     ]
     *     simulationOnly: Boolean (Optional)
     *     riskCategories (Optional): [
     *         String(HateUnfairness/Violence/Sexual/SelfHarm) (Optional)
     *     ]
     *     applicationScenario: String (Optional)
     *     tags (Optional): {
     *         String: String (Required)
     *     }
     *     properties (Optional): {
     *         String: String (Required)
     *     }
     *     status: String (Optional)
     *     target (Required): {
     *         type: String (Required)
     *     }
     * }
     * }
     * </pre>
     * 
     * <p><strong>Response Body Schema</strong></p>
     * 
     * <pre>
     * {@code
     * {
     *     id: String (Required)
     *     displayName: String (Optional)
     *     numTurns: Integer (Optional)
     *     attackStrategies (Optional): [
     *         String(easy/moderate/difficult/ascii_art/ascii_smuggler/atbash/base64/binary/caesar/character_space/jailbreak/ansii_attack/character_swap/suffix_append/string_join/unicode_confusable/unicode_substitution/diacritic/flip/leetspeak/rot13/morse/url/baseline) (Optional)
     *     ]
     *     simulationOnly: Boolean (Optional)
     *     riskCategories (Optional): [
     *         String(HateUnfairness/Violence/Sexual/SelfHarm) (Optional)
     *     ]
     *     applicationScenario: String (Optional)
     *     tags (Optional): {
     *         String: String (Required)
     *     }
     *     properties (Optional): {
     *         String: String (Required)
     *     }
     *     status: String (Optional)
     *     target (Required): {
     *         type: String (Required)
     *     }
     * }
     * }
     * </pre>
     * 
     * @param redTeam Redteam to be run.
     * @param requestOptions The options to configure the HTTP request before HTTP client sends it.
     * @throws HttpResponseException thrown if the request is rejected by server.
     * @throws ClientAuthenticationException thrown if the request is rejected by server on status code 401.
     * @throws ResourceNotFoundException thrown if the request is rejected by server on status code 404.
     * @throws ResourceModifiedException thrown if the request is rejected by server on status code 409.
     * @return red team details along with {@link Response}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<BinaryData> createRedTeamWithResponse(BinaryData redTeam, RequestOptions requestOptions) {
        final String contentType = "application/json";
        final String accept = "application/json";
        return service.createRedTeamSync(this.client.getEndpoint(), this.client.getServiceVersion().getVersion(),
            contentType, accept, redTeam, requestOptions, Context.NONE);
    }

    /**
     * Get the next page of items.
     * <p><strong>Response Body Schema</strong></p>
     * 
     * <pre>
     * {@code
     * {
     *     id: String (Required)
     *     displayName: String (Optional)
     *     numTurns: Integer (Optional)
     *     attackStrategies (Optional): [
     *         String(easy/moderate/difficult/ascii_art/ascii_smuggler/atbash/base64/binary/caesar/character_space/jailbreak/ansii_attack/character_swap/suffix_append/string_join/unicode_confusable/unicode_substitution/diacritic/flip/leetspeak/rot13/morse/url/baseline) (Optional)
     *     ]
     *     simulationOnly: Boolean (Optional)
     *     riskCategories (Optional): [
     *         String(HateUnfairness/Violence/Sexual/SelfHarm) (Optional)
     *     ]
     *     applicationScenario: String (Optional)
     *     tags (Optional): {
     *         String: String (Required)
     *     }
     *     properties (Optional): {
     *         String: String (Required)
     *     }
     *     status: String (Optional)
     *     target (Required): {
     *         type: String (Required)
     *     }
     * }
     * }
     * </pre>
     * 
     * @param nextLink The URL to get the next list of items.
     * @param requestOptions The options to configure the HTTP request before HTTP client sends it.
     * @throws HttpResponseException thrown if the request is rejected by server.
     * @throws ClientAuthenticationException thrown if the request is rejected by server on status code 401.
     * @throws ResourceNotFoundException thrown if the request is rejected by server on status code 404.
     * @throws ResourceModifiedException thrown if the request is rejected by server on status code 409.
     * @return paged collection of RedTeam items along with {@link PagedResponse} on successful completion of
     * {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    private Mono<PagedResponse<BinaryData>> listRedTeamsNextSinglePageAsync(String nextLink,
        RequestOptions requestOptions) {
        final String accept = "application/json";
        return FluxUtil.withContext(
            context -> service.listRedTeamsNext(nextLink, this.client.getEndpoint(), accept, requestOptions, context))
            .map(res -> new PagedResponseBase<>(res.getRequest(), res.getStatusCode(), res.getHeaders(),
                getValues(res.getValue(), "value"), getNextLink(res.getValue(), "nextLink"), null));
    }

    /**
     * Get the next page of items.
     * <p><strong>Response Body Schema</strong></p>
     * 
     * <pre>
     * {@code
     * {
     *     id: String (Required)
     *     displayName: String (Optional)
     *     numTurns: Integer (Optional)
     *     attackStrategies (Optional): [
     *         String(easy/moderate/difficult/ascii_art/ascii_smuggler/atbash/base64/binary/caesar/character_space/jailbreak/ansii_attack/character_swap/suffix_append/string_join/unicode_confusable/unicode_substitution/diacritic/flip/leetspeak/rot13/morse/url/baseline) (Optional)
     *     ]
     *     simulationOnly: Boolean (Optional)
     *     riskCategories (Optional): [
     *         String(HateUnfairness/Violence/Sexual/SelfHarm) (Optional)
     *     ]
     *     applicationScenario: String (Optional)
     *     tags (Optional): {
     *         String: String (Required)
     *     }
     *     properties (Optional): {
     *         String: String (Required)
     *     }
     *     status: String (Optional)
     *     target (Required): {
     *         type: String (Required)
     *     }
     * }
     * }
     * </pre>
     * 
     * @param nextLink The URL to get the next list of items.
     * @param requestOptions The options to configure the HTTP request before HTTP client sends it.
     * @throws HttpResponseException thrown if the request is rejected by server.
     * @throws ClientAuthenticationException thrown if the request is rejected by server on status code 401.
     * @throws ResourceNotFoundException thrown if the request is rejected by server on status code 404.
     * @throws ResourceModifiedException thrown if the request is rejected by server on status code 409.
     * @return paged collection of RedTeam items along with {@link PagedResponse}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    private PagedResponse<BinaryData> listRedTeamsNextSinglePage(String nextLink, RequestOptions requestOptions) {
        final String accept = "application/json";
        Response<BinaryData> res
            = service.listRedTeamsNextSync(nextLink, this.client.getEndpoint(), accept, requestOptions, Context.NONE);
        return new PagedResponseBase<>(res.getRequest(), res.getStatusCode(), res.getHeaders(),
            getValues(res.getValue(), "value"), getNextLink(res.getValue(), "nextLink"), null);
    }

    private List<BinaryData> getValues(BinaryData binaryData, String path) {
        try {
            Map<?, ?> obj = binaryData.toObject(Map.class);
            List<?> values = (List<?>) obj.get(path);
            return values.stream().map(BinaryData::fromObject).collect(Collectors.toList());
        } catch (RuntimeException e) {
            return null;
        }
    }

    private String getNextLink(BinaryData binaryData, String path) {
        try {
            Map<?, ?> obj = binaryData.toObject(Map.class);
            return (String) obj.get(path);
        } catch (RuntimeException e) {
            return null;
        }
    }
}
