package com.example.shop.member;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.processing.Generated;

@Entity
@Setter
@Getter
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String username;
    private String displayName;
    private String password;
}
