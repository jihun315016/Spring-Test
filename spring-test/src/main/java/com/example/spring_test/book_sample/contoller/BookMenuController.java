package com.example.spring_test.book_sample.contoller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.spring_test.book_sample.models.entity.Menu;
import com.example.spring_test.book_sample.service.BookMenuService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class BookMenuController {
    private final BookMenuService menuService;

    @ResponseBody
    @PostMapping("/book_menu")
    public List<Menu> menu() {
        List<Menu> list = menuService.findAll();
        System.out.println("Hello World Menu");
        return list;
    }
}
