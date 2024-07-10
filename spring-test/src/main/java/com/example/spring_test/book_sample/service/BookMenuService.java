package com.example.spring_test.book_sample.service;

import org.springframework.stereotype.Service;

import com.example.spring_test.book_sample.models.entity.Menu;

import java.util.List;
import java.util.ArrayList;

@Service
public class BookMenuService {
    public List<Menu> findAll() {
        List<Menu> list = new ArrayList<>();
        
        list.add(Menu.builder()
            .id(1)
            .level(1)
            .menuName("first")
            .build()
        );
        
        list.add(Menu.builder()
            .id(2)
            .level(2)
            .menuName("first_one")
            .path("/first_one")
            .parentMenuId(1)
            .build()
        );

        list.add(Menu.builder()
            .id(3)
            .level(2)
            .menuName("first_two")
            .path("/first_two")
            .parentMenuId(1)
            .build()
        );

        list.add(Menu.builder()
            .id(4)
            .level(1)
            .menuName("second")
            .build()
        );
        
        list.add(Menu.builder()
            .id(2)
            .level(5)
            .menuName("second_one")
            .path("/second_one")
            .parentMenuId(4)
            .build()
        );

        return list;
    }
}
