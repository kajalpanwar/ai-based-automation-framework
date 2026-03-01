package com.automation.framework.config;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

/**
 * RestAssured request specification configuration.
 * Provides reusable request specs for consistent API calls.
 * Integrates Allure RestAssured filter for request/response capture in reports.
 */
public final class ApiConfig {

    private static RequestSpecification baseSpec;

    private ApiConfig() {
    }

    public static RequestSpecification getBaseSpec() {
        if (baseSpec == null) {
            baseSpec = new RequestSpecBuilder()
                    .setBaseUri(Config.getBaseUrl())
                    .setContentType(ContentType.JSON)
                    .setAccept(ContentType.JSON)
                    .setRelaxedHTTPSValidation()
                    .addFilter(new AllureRestAssured())
                    .setConfig(RestAssured.config()
                            .httpClient(io.restassured.config.HttpClientConfig.httpClientConfig()
                                    .setParam("http.connection.timeout", Config.getConnectionTimeout())
                                    .setParam("http.socket.timeout", Config.getReadTimeout())))
                    .log(LogDetail.ALL)
                    .build();
        }
        return baseSpec;
    }

    public static void reset() {
        baseSpec = null;
    }
}
