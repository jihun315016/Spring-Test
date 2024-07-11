package com.example.spring_test.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

// Spring Security 설정을 지정할 수 있는 어노테이션
@Configuration
@EnableWebSecurity 
public class SecurityConfig {
    @Bean
    PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        // 뭔가 나중에 공부할 것 같은 느낌이니까 일단 넘거갈거
        httpSecurity.csrf(csrf -> csrf.disable());

        // URL 기반 권한 설정
        // 인증 여부에 상관 없이 모든 경로에 대해 접근을 허용한다.
        // /** : 모든 경로
        // permitAll : 항상 허용
        httpSecurity.authorizeHttpRequests(
            authorize -> authorize.requestMatchers("/**").permitAll()
        );

        // HTML의 <form> 태그를 이용한 로그인 설정
        // 로그인 경로와 성공, 실패 시 이동할 경로 설정
        // failureUrl은 '/login?error'이 기본 경로
        httpSecurity.formLogin(
            login -> login.loginPage("/login")
            .defaultSuccessUrl("/")
            .failureUrl("/login?error") 
        );

        // 로그아웃 설정
        httpSecurity.logout(logout -> logout
            .logoutUrl("/logout")
            .logoutSuccessUrl("/")
            .deleteCookies("JSESSIONID") // 로그아웃 시 세션 쿠키를 삭제합니다.
            .invalidateHttpSession(true)); // 로그아웃 시 세션을 무효화합니다.

        return httpSecurity.build();
    }
}
