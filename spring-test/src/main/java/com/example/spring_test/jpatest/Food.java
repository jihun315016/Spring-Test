package com.example.spring_test.jpatest;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Builder;

@NoArgsConstructor(access = AccessLevel.PROTECTED) 
@AllArgsConstructor
@Builder
@Getter
@Entity
@Table(name="food")
public class Food {
    @Id
    @Column(name="id")
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name="price")
    private int price;

    @Column(name="description")
    private String description;
}
