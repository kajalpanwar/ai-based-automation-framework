package com.automation.framework.tests;

import com.automation.framework.base.BaseTest;
import com.automation.framework.models.Post;
import com.automation.framework.utils.Constants;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Test class for Posts API endpoints.
 */
public class PostsApiTest extends BaseTest {

    @Test(description = "Verify GET /posts returns list of posts")
    public void getAllPosts_shouldReturn200AndNonEmptyList() {
        var response = postsApi.getAllPosts();

        assertEquals(response.getStatusCode(), Constants.HttpStatus.OK);
        assertNotNull(response.getBody());
        assertFalse(response.getBody().isEmpty());
    }

    @Test(description = "Verify GET /posts/{id} returns correct post")
    public void getPostById_shouldReturn200AndMatchingPost() {
        long postId = 1;
        var response = postsApi.getPostById(postId);

        assertEquals(response.getStatusCode(), Constants.HttpStatus.OK);
        assertNotNull(response.getBody());
        assertEquals(response.getBody().getId(), Long.valueOf(postId));
    }

    @Test(description = "Verify POST /posts creates a new post")
    public void createPost_shouldReturn201AndCreatedPost() {
        Post newPost = Post.builder()
                .userId(1L)
                .title("Test Title")
                .body("Test Body Content")
                .build();

        var response = postsApi.createPost(newPost);

        assertEquals(response.getStatusCode(), Constants.HttpStatus.CREATED);
        assertNotNull(response.getBody());
        assertEquals(response.getBody().getTitle(), newPost.getTitle());
        assertEquals(response.getBody().getBody(), newPost.getBody());
    }

    @Test(description = "Verify PUT /posts/{id} updates existing post")
    public void updatePost_shouldReturn200AndUpdatedPost() {
        long postId = 1;
        Post updatedPost = Post.builder()
                .id(postId)
                .userId(1L)
                .title("Updated Title")
                .body("Updated Body")
                .build();

        var response = postsApi.updatePost(postId, updatedPost);

        assertEquals(response.getStatusCode(), Constants.HttpStatus.OK);
        assertNotNull(response.getBody());
        assertEquals(response.getBody().getTitle(), updatedPost.getTitle());
    }

    @Test(description = "Verify DELETE /posts/{id} returns 200")
    public void deletePost_shouldReturn200() {
        long postId = 1;
        var response = postsApi.deletePost(postId);

        assertEquals(response.getStatusCode(), Constants.HttpStatus.OK);
    }
}
