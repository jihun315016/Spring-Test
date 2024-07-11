package com.example.spring_test.security;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Builder;

@NoArgsConstructor(access = AccessLevel.PROTECTED) // 엔티티는 반드시 기본 생성자가 있어야 <- 기본 생성자 지정
@AllArgsConstructor
@Builder
@Getter
@Entity
@Table(name="my_user")
public class MyUser {
    @Id
    @Column(name = "user_id", updatable = false)
    private String userId;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "user_name")
    private String userName;
}
