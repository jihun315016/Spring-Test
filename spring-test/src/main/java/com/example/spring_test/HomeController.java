package com.example.spring_test;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {
    @GetMapping("/")
    public String home(Authentication auth) {
        System.out.println("=====");
        System.out.println(auth);
        return "content.html";
    }

    @ResponseBody
    @GetMapping("/test")
    public String test() {
        return "Hello World";
    }
}
