package com.sample.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sample.demo.models.entity.Menu;
import com.sample.demo.repository.MenuRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class MenuService {
    private final MenuRepository menuRepository;

    public List<Menu> findAll() {
        List<Menu> list = menuRepository.findAll();
        return list;
    }
}
