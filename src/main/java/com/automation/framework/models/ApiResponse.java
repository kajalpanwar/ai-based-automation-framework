package com.automation.framework.models;

/**
 * Generic wrapper for API response metadata.
 * Use for consistent response handling across endpoints.
 */
public class ApiResponse<T> {

    private final int statusCode;
    private final T body;
    private final String contentType;
    private final long responseTime;

    public ApiResponse(int statusCode, T body, String contentType, long responseTime) {
        this.statusCode = statusCode;
        this.body = body;
        this.contentType = contentType;
        this.responseTime = responseTime;
    }

    public static <T> ApiResponse<T> of(int statusCode, T body, String contentType, long responseTime) {
        return new ApiResponse<>(statusCode, body, contentType, responseTime);
    }

    public int getStatusCode() {
        return statusCode;
    }

    public T getBody() {
        return body;
    }

    public String getContentType() {
        return contentType;
    }

    public long getResponseTime() {
        return responseTime;
    }
}
