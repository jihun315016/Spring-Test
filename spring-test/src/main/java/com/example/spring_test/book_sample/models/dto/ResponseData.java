package com.example.spring_test.book_sample.models.dto;

public class ResponseData<T> {
    private String errorCode;

    private String errorMessage;
    
    private String userErrorMessage;

    private T data;
}
