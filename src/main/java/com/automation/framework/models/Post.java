package com.automation.framework.models;

import com.google.gson.annotations.SerializedName;

/**
 * Model representing a Post entity (request/response DTO).
 */
public class Post {

    private Long id;
    private Long userId;
    private String title;
    private String body;

    public Post() {
    }

    public Post(Long id, Long userId, String title, String body) {
        this.id = id;
        this.userId = userId;
        this.title = title;
        this.body = body;
    }

    public static PostBuilder builder() {
        return new PostBuilder();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @SerializedName("userId")
    public Long getUserId() {
        return userId;
    }

    @SerializedName("userId")
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public static final class PostBuilder {
        private Long id;
        private Long userId;
        private String title;
        private String body;

        private PostBuilder() {
        }

        public PostBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public PostBuilder userId(Long userId) {
            this.userId = userId;
            return this;
        }

        public PostBuilder title(String title) {
            this.title = title;
            return this;
        }

        public PostBuilder body(String body) {
            this.body = body;
            return this;
        }

        public Post build() {
            return new Post(id, userId, title, body);
        }
    }
}
