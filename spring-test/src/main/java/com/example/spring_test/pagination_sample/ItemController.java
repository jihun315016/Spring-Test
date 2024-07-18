package com.example.spring_test.pagination_sample;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Page;

@RequiredArgsConstructor
@Controller
public class ItemController {
    private final ItemRepository itemRepository;

    @GetMapping("/list/{page}")
    String list(Model model, @PathVariable Integer page) {
        // findByNameContaining(검색어, PageRequest.of(몇 번째 페이지, 한 페이지 당 몇 개))
        // 페이지는 0부터 세어준다.
        Slice<Item> result = itemRepository.findByNameContaining("", PageRequest.of(page - 1, 3));
        // Page<Item> result = itemRepository.findPageBy(PageRequest.of(page - 1, 3));
        model.addAttribute("items", result);
        return "pagination_sample/list.html";
    }
}
