package com.example.spring_test.jpatest;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import java.util.List;

@RequiredArgsConstructor
@Service
public class FoodService {
    private final FoodRepository foodRepository;

    public List<Food> findAll() {
        return foodRepository.findAll();
    }

    public void save(Food food) {
        foodRepository.save(food);
    }
}
