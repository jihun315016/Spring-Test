package com.example.shop;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BasicController {
    @GetMapping("/")
    public String hello() {
        // static 폴더가 기본 경로로 잡히기 때문에 파일명만 적으면 알아서 파일을 보내줌
        return "index.html";
    }

    @GetMapping("/about")
    @ResponseBody
    public String about() {
        return "사이트에요.";
    }
}
