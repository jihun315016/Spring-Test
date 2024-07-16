package com.example.spring_test.book_sample.models.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Builder;

@Builder
@Getter
// @AllArgsConstructor
// @Entity
// @Table(name="role")
public class Role {
    private String id;

    private String roleName;
}
