package com.example.spring_test.book_sample.models.entity;

import groovy.transform.builder.Builder;
import lombok.Getter;

@Builder
@Getter
public class CommonCode {
    private String codeGroup;

    private String code;

    private String name;

    private String description;
}
