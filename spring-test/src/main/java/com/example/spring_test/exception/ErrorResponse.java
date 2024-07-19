package com.example.spring_test.exception;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ErrorResponse {
    private int errorCode;
    private String errorMessage;
    private String requestUrl;
    private Timestamp timestamp;

    public ErrorResponse(int errorCode, String errorMessage, String requestUrl) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.requestUrl = requestUrl;
        this.timestamp = new Timestamp(System.currentTimeMillis());
    }
}
