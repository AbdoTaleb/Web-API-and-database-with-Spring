package com.example.movies.controllers;

import java.time.LocalDateTime;

public class ApiErrorResponse {
    private String timestamp;
    private Integer status;
    private String error;
    private String trace;
    private String message;
    private String path;

    public ApiErrorResponse(Integer status, String error, String trace, String message, String path) {
        this();
        this.timestamp = String.valueOf(LocalDateTime.now());;
        this.status = status;
        this.error = error;
        this.trace = trace;
        this.message = message;
        this.path = path;
    }

    public ApiErrorResponse() {

    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getTrace() {
        return trace;
    }

    public void setTrace(String trace) {
        this.trace = trace;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }


}
