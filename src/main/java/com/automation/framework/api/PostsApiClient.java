package com.automation.framework.api;

import com.automation.framework.models.ApiResponse;
import com.automation.framework.models.Post;
import io.restassured.response.Response;

import java.util.Arrays;
import java.util.List;

/**
 * API client for Posts endpoints.
 * Encapsulates all Posts-related API operations.
 */
public class PostsApiClient extends BaseApiClient {

    private static final String POSTS_PATH = "/posts";
    private static final String POST_BY_ID_PATH = "/posts/{id}";

    public ApiResponse<List<Post>> getAllPosts() {
        Response response = executeGet(POSTS_PATH);
        Post[] posts = response.as(Post[].class);
        return ApiResponse.of(
                response.getStatusCode(),
                Arrays.asList(posts),
                response.getContentType(),
                response.getTime()
        );
    }

    public ApiResponse<Post> getPostById(long id) {
        Response response = executeGet(POST_BY_ID_PATH, id);
        return ApiResponse.of(
                response.getStatusCode(),
                response.as(Post.class),
                response.getContentType(),
                response.getTime()
        );
    }

    public ApiResponse<Post> createPost(Post post) {
        Response response = executePost(POSTS_PATH, post);
        return ApiResponse.of(
                response.getStatusCode(),
                response.as(Post.class),
                response.getContentType(),
                response.getTime()
        );
    }

    public ApiResponse<Post> updatePost(long id, Post post) {
        Response response = executePut(POST_BY_ID_PATH, post, id);
        return ApiResponse.of(
                response.getStatusCode(),
                response.as(Post.class),
                response.getContentType(),
                response.getTime()
        );
    }

    public ApiResponse<Void> deletePost(long id) {
        Response response = executeDelete(POST_BY_ID_PATH, id);
        return ApiResponse.of(
                response.getStatusCode(),
                null,
                response.getContentType(),
                response.getTime()
        );
    }
}
