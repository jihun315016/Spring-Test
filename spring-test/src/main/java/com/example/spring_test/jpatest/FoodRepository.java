package com.example.spring_test.jpatest;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface FoodRepository extends JpaRepository<Food, Long> 
{ 
    <T> List<T> findAllBy(Class<T> type);
    //List<FoodMapping> findAllBy();
}

