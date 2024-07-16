package com.sample.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sample.demo.models.entity.Menu;

public interface MenuRepository extends JpaRepository<Menu, Integer> { }
