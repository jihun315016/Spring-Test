package com.example.shop;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

// 아무 클래스에나 아래 두 개의 어노테이션을 붙여주면 스프링 시큐리티의 설정들을 지정할 수 있다.
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // @Bean는 클래스가 아니라 메서드 위에 작성하는 것
    // 이거 쓰면 메서드가 반환하는 타입을 객체를 Bean(스프링이 뽑은 오브젝트)으로 등록한다.
    // 빈으로 등록할 때는 아무 접근지정자를 써도 의미가 없다.
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        // FilterChain은 유저의 요청과 서버의 응답 사이에 자동으로 실행해주고 싶은 코드를 담는 곳

        // csrf는 api를 하나 만들어두면 다른 사이트에서도 요청할 수 있음
        // 그냥 다른 사이트에다가 폼 만들고 url 부분에다만 만든 주소로 하는거
        // 그럼 다른 사이트에서 우리 사이트에 글을 올리고 이런 것들이 가능해짐
        // 이걸 csrf 기능이라고 하는데 이걸 방지하고 싶으면 csrf 기능을 키면 됌
        // 이거 키면 내 사이트의 form에서 랜덤 문자열을 함께 제출함
        // 이게 서버측의 문자열이랑 맞는지 검사하고 맞으면 통과시켜주는 식
        // jwt를 사용하는 경우 jwt 입장권을 직접 헤더에 넣어서 보내면 csrf 문제 해결
        // 그래서 jwt를 쓰는 사람은 이걸 끄는 경우가 많고 세션 방식이면 키는 게 좋음, 근데 일단은 꺼둘거
        http.csrf((csrf) -> csrf.disable());

        // 특정 페이지에 로그인 검사를 할지말지 결정
        // /** : 모든 url
        // permitAll : 항상 허용
        http.authorizeHttpRequests((authorize) ->
                authorize.requestMatchers("/**").permitAll()
        );

        // HTML의 <form> 태그를 이용한 로그인 설정
        http.formLogin((formLogin) -> formLogin.loginPage("/login")
                .defaultSuccessUrl("/") // 로그인 성공시 이동할 url
                .failureUrl("/fail") // 로그인 실패시 이동할 url
                // 이거 안 쓰면 실패시 기본적으로 /login?error 페이지로 이동함, 원래 코드는 fail 안썼음
        );

        // 로그아웃 하는 방법
        http.logout(logout -> logout
                .logoutUrl("/logout")
                .logoutSuccessUrl("/")
                .deleteCookies("JSESSIONID") // 로그아웃 시 세션 쿠키를 삭제합니다.
                .invalidateHttpSession(true)); // 로그아웃 시 세션을 무효화합니다.

        return http.build();
    }
}