package com.example.spring_test.jpatest;

import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@RestController
public class FoodController {
    private final FoodRepository foodRepository;

    @GetMapping("/findAllBy")
    public List<FoodMapping> findAllBy() {
        return foodRepository.findAllBy(FoodMapping.class);
    }
}
