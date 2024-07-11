package com.example.spring_test.security;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface MyUserRepository extends JpaRepository<MyUser, String> 
{  
    Optional<MyUser> findByUserId(String userId);
} 
