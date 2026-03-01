package com.automation.framework.api;

import com.automation.framework.models.ApiResponse;
import com.automation.framework.models.User;
import io.restassured.response.Response;

import java.util.Arrays;
import java.util.List;

/**
 * API client for Users endpoints.
 * Encapsulates all Users-related API operations.
 */
public class UsersApiClient extends BaseApiClient {

    private static final String USERS_PATH = "/users";
    private static final String USER_BY_ID_PATH = "/users/{id}";

    public ApiResponse<List<User>> getAllUsers() {
        Response response = executeGet(USERS_PATH);
        User[] users = response.as(User[].class);
        return ApiResponse.of(
                response.getStatusCode(),
                Arrays.asList(users),
                response.getContentType(),
                response.getTime()
        );
    }

    public ApiResponse<User> getUserById(long id) {
        Response response = executeGet(USER_BY_ID_PATH, id);
        return ApiResponse.of(
                response.getStatusCode(),
                response.as(User.class),
                response.getContentType(),
                response.getTime()
        );
    }

    /**
     * Create a new user. Returns Response for fluent assertions (e.g. .then().statusCode(201)).
     */
    public Response createUser(Object payload) {
        return executePost(USERS_PATH, payload);
    }
}
