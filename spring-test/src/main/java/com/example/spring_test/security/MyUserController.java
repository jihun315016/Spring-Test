package com.example.spring_test.security;

import java.util.Optional;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RequiredArgsConstructor
@Controller
public class MyUserController {
    private final MyUserRepository myUserRepository;
    private final PasswordEncoder passwordEncoder;

    @GetMapping("/login")
    public String login() {
        return "login.html";
    }

    @GetMapping("/save_user")
    @ResponseBody
    public List<MyUser> saveUser() {
        Optional<MyUser> oUser = myUserRepository.findById("admin");
        MyUser user;
        if (oUser.isEmpty()) {
            user = MyUser.builder()
                .userId("admin")
                .password(passwordEncoder.encode("1234"))
                .userName("kim")
                .build();

            myUserRepository.save(user);
        } 

        List<MyUser> list = myUserRepository.findAll();
        return list;
    }

    // 함수 위에 이런거 쓰면 로그인 여부 검사하는 로직 간편하게 넣기 가능
    // @PreAuthorize("isAnonymous()")
    // @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    // @PreAuthorize("isAuthenticated()") // 인증 안 됐는데 요청하면 인증 페이지(/login)로 이동
    @GetMapping("/my-page")
    public String myPage(Authentication auth) {       
        if (auth != null && auth.isAuthenticated()) {
            // 인증된 사용자에 대한 처리
            User user = (User)auth.getPrincipal();
            System.out.println(user.getUsername());     // admin
            System.out.println(user.getAuthorities());  // [ROLE_ADMIN]
            return "mypage.html";
        } else {
            // 인증되지 않은 사용자에 대한 처리
            // 인증 후 로그아웃 상태의 경우 auth가 null이 아님
            return "login.html";
        }
    }


    @ResponseBody
    @PostMapping("/security_test")
    public MyUser securityTest() {
        return new MyUser().builder()
            .userId("myid")
            .password("1234")
            .build();
    }
}
