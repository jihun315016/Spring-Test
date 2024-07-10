package com.example.spring_test.book_sample.models.entity;

import lombok.Getter;
import lombok.Builder;
import lombok.ToString;

@Builder
@Getter
@ToString
public class Menu {
    private int id;

    private int level;

    private String menuName;

    private String path;

    private int parentMenuId;
}
