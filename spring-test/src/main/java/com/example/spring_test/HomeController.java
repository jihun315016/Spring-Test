package com.example.spring_test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {
    @GetMapping("/")
    public String home() {
        return "content.html";
    }

    @ResponseBody
    @GetMapping("/test")
    public String test() {
        return "Hello World";
    }
}
