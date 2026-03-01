package com.automation.framework.api;

import com.automation.framework.config.ApiConfig;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

/**
 * API client that wraps RestAssured requests.
 * Supports GET, POST, and PUT operations.
 */
public class ApiClient {

    private final RequestSpecification requestSpec;

    public ApiClient() {
        this.requestSpec = io.restassured.RestAssured
                .given()
                .spec(ApiConfig.getBaseSpec());
    }

    public ApiClient(RequestSpecification spec) {
        this.requestSpec = spec;
    }

    /**
     * Execute GET request.
     *
     * @param path the endpoint path (e.g. "/users" or "/posts/{id}")
     * @return RestAssured Response
     */
    public Response get(String path) {
        return requestSpec.when().get(path);
    }

    /**
     * Execute GET request with path parameters.
     *
     * @param path       the endpoint path with placeholders (e.g. "/posts/{id}")
     * @param pathParams values for path placeholders
     * @return RestAssured Response
     */
    public Response get(String path, Object... pathParams) {
        return requestSpec.when().get(path, pathParams);
    }

    /**
     * Execute POST request.
     *
     * @param path the endpoint path (e.g. "/posts")
     * @param body the request body (Object will be serialized to JSON)
     * @return RestAssured Response
     */
    public Response post(String path, Object body) {
        return requestSpec.body(body).when().post(path);
    }

    /**
     * Execute POST request with path parameters.
     *
     * @param path       the endpoint path with placeholders
     * @param body       the request body
     * @param pathParams values for path placeholders
     * @return RestAssured Response
     */
    public Response post(String path, Object body, Object... pathParams) {
        return requestSpec.body(body).when().post(path, pathParams);
    }

    /**
     * Execute PUT request.
     *
     * @param path the endpoint path (e.g. "/posts/1")
     * @param body the request body
     * @return RestAssured Response
     */
    public Response put(String path, Object body) {
        return requestSpec.body(body).when().put(path);
    }

    /**
     * Execute PUT request with path parameters.
     *
     * @param path       the endpoint path with placeholders (e.g. "/posts/{id}")
     * @param body       the request body
     * @param pathParams values for path placeholders
     * @return RestAssured Response
     */
    public Response put(String path, Object body, Object... pathParams) {
        return requestSpec.body(body).when().put(path, pathParams);
    }

    /**
     * Create a new user. Returns Response for fluent assertions (e.g. .then().statusCode(201)).
     *
     * @param payload the user payload to create
     * @return RestAssured Response
     */
    public Response createUser(Object payload) {
        return post("/users", payload);
    }

    /**
     * Get the underlying RequestSpecification for custom configuration.
     */
    public RequestSpecification getRequestSpec() {
        return requestSpec;
    }
}
