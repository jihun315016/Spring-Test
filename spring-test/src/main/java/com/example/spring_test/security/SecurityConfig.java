package com.example.spring_test.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;

// Spring Security 설정을 지정할 수 있는 어노테이션
@Configuration
@EnableWebSecurity 
@EnableMethodSecurity(prePostEnabled = true) // 이거 해야 컨트롤러에서 @PreAuthorize 애너테이션 쓸 수 있음
public class SecurityConfig {
    @Bean
    PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // CSRF 공격 방지를 위해 랜덤한 토큰 생성
    // @Bean
    // public CsrfTokenRepository csrfTokenRepository() {
    //     HttpSessionCsrfTokenRepository repository = new HttpSessionCsrfTokenRepository();
    //     repository.setHeaderName("X-XSRF-TOKEN");
    //     return repository;
    // }

    @Bean
    SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        // CSRF 보안 기능 비활성화
        httpSecurity.csrf(csrf -> csrf.disable());
        
        // CSRF 보안 기능 활성화
        // CSRF는 사용자 인증 정보를 이용하여 악의적인 요청을 보내는 공격
        // 가능 활성화 시 뷰에 두 가지 작업 필요
        // 1. <form> 태그 내부에 아래 태그 추가하기 
        // - <input type="hidden" th:name="${_csrf.parameterName}" th:value="${_csrf.token}"> 추가하기
        // 2. ajax 요청 시에도 CSRF 토큰을 넣어서 요청 보내기
        // httpSecurity.csrf(csrf -> csrf.csrfTokenRepository(csrfTokenRepository())
        //        .ignoringRequestMatchers("/login") // CSRF 기능에서 제외할
        // );


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
            .logoutSuccessUrl("/login")
            .deleteCookies("JSESSIONID") // 로그아웃 시 세션 쿠키를 삭제합니다.
            .invalidateHttpSession(true)); // 로그아웃 시 세션을 무효화합니다.

        return httpSecurity.build();
    }
}
