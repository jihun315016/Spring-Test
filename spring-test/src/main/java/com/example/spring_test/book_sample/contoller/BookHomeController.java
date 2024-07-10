package com.example.spring_test.book_sample.contoller;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.spring_test.book_sample.models.dto.aladin.ItemListDTO;
import com.example.spring_test.book_sample.models.entity.Menu;
import com.example.spring_test.book_sample.service.BookHomeService;
import org.springframework.ui.Model;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class BookHomeController {
    private final BookHomeService homeService;
    
    @GetMapping("/book_sample")
    public String Index(Model model) throws IOException {
        List<ItemListDTO> list = homeService.findData();
        model.addAttribute("data", list);
        return "book_sample/book_index.html";
    }
}
