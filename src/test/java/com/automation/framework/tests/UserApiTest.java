package com.automation.framework.tests;

import com.automation.framework.api.ApiClient;
import com.automation.framework.models.User;
import org.testng.annotations.Test;

/**
 * Test class for User API operations.
 */
public class UserApiTest {

    private final ApiClient apiClient = new ApiClient();

    @Test
    public void createUserTest() {
        User payload = new User();
        payload.setName("John Doe");
        payload.setUsername("johndoe");
        payload.setEmail("john.doe@example.com");

        apiClient.createUser(payload)
                .then()
                .statusCode(201);
    }
}
