package com.example.spring_test.pagination_sample;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;

import org.springframework.data.domain.Slice;

public interface ItemRepository extends JpaRepository<Item, Long> {
    // Page<Item> findPageBy(Pageable page);

    Slice<Item> findByNameContaining(String name, Pageable pageable);
}
