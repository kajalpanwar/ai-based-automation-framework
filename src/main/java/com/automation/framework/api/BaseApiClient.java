package com.automation.framework.api;

import com.automation.framework.config.ApiConfig;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

/**
 * Base API client providing common request execution logic.
 * All API clients should extend this for consistent behavior.
 */
public abstract class BaseApiClient {

    protected RequestSpecification given() {
        return io.restassured.RestAssured
                .given()
                .spec(ApiConfig.getBaseSpec());
    }

    protected Response executeGet(String path) {
        return given().when().get(path);
    }

    protected Response executeGet(String path, Object... pathParams) {
        return given().when().get(path, pathParams);
    }

    protected Response executePost(String path, Object body) {
        return given().body(body).when().post(path);
    }

    protected Response executePut(String path, Object body) {
        return given().body(body).when().put(path);
    }

    protected Response executePut(String path, Object body, Object... pathParams) {
        return given().body(body).when().put(path, pathParams);
    }

    protected Response executePatch(String path, Object body) {
        return given().body(body).when().patch(path);
    }

    protected Response executePatch(String path, Object body, Object... pathParams) {
        return given().body(body).when().patch(path, pathParams);
    }

    protected Response executeDelete(String path) {
        return given().when().delete(path);
    }

    protected Response executeDelete(String path, Object... pathParams) {
        return given().when().delete(path, pathParams);
    }
}
