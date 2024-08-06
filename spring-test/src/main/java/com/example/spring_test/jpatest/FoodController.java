package com.example.spring_test.jpatest;

import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@RequiredArgsConstructor
@RestController
public class FoodController {
    private final FoodService foodService;

    // @GetMapping("/findAllBy")
    // public List<FoodMapping> findAllBy() {
    //     return foodService.findAllBy(FoodMapping.class);
    // }

    @ResponseBody
    @GetMapping("/list")
    public List<Food> findAll() {
        return foodService.findAll();
    }

    // {
    //     "id": 3,
    //     "name": "new food",
    //     "price": 20000
    // }
    @ResponseBody
    @PostMapping("/save")
    public void save(@RequestBody Food food) {
        foodService.save(food);
    }
}
