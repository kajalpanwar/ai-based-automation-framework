package com.automation.framework.tests;

import com.automation.framework.base.BaseTest;
import com.automation.framework.utils.Constants;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Test class for Users API endpoints.
 */
public class UsersApiTest extends BaseTest {

    @Test(description = "Verify GET /users returns list of users")
    public void getAllUsers_shouldReturn200AndNonEmptyList() {
        var response = usersApi.getAllUsers();

        assertEquals(response.getStatusCode(), Constants.HttpStatus.OK);
        assertNotNull(response.getBody());
        assertFalse(response.getBody().isEmpty());
    }

    @Test(description = "Verify GET /users/{id} returns correct user")
    public void getUserById_shouldReturn200AndMatchingUser() {
        long userId = 1;
        var response = usersApi.getUserById(userId);

        assertEquals(response.getStatusCode(), Constants.HttpStatus.OK);
        assertNotNull(response.getBody());
        assertEquals(response.getBody().getId(), Long.valueOf(userId));
        assertNotNull(response.getBody().getName());
        assertNotNull(response.getBody().getEmail());
    }
}
