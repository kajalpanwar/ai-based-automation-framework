package com.automation.framework.base;

import com.automation.framework.api.PostsApiClient;
import com.automation.framework.api.UsersApiClient;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

/**
 * Base test class for all API tests.
 * Provides shared setup and teardown at suite level.
 */
public abstract class BaseTest {

    protected static PostsApiClient postsApi;
    protected static UsersApiClient usersApi;

    @BeforeSuite(alwaysRun = true)
    public void baseSetup() {
        postsApi = new PostsApiClient();
        usersApi = new UsersApiClient();
    }

    @AfterSuite(alwaysRun = true)
    public void baseTearDown() {
        postsApi = null;
        usersApi = null;
    }
}
