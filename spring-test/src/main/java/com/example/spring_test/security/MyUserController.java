package com.example.spring_test.security;

import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import lombok.RequiredArgsConstructor;


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
}
