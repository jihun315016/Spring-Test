package com.example.spring_test.book_sample.models.dto.aladin;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class RequestData {
    private String url;
    private String method;
    private String userAgent;
}

