package com.example.spring_test.book_sample.contoller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BookAccountController {
    @GetMapping("/signup")
    public String Signup() {
        return "book_sample/account/book_signup.html";
    }

    @PostMapping("/signup")
    public String Signup(Model model) {
        // 회원 가입 하는 로직
        return "redirect:/book_sample/account/book_signin.html";
    }
}
