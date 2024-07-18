package com.example.spring_test.pagination_sample;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Builder;
import lombok.ToString;

@NoArgsConstructor(access = AccessLevel.PROTECTED) 
@AllArgsConstructor
@Builder
@Getter
@ToString
@Entity
@Table(name="item")
public class Item {
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;
}
