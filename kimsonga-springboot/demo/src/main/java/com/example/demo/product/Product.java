package com.example.demo.product;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity // 엔티티 매니저가 관리하는걸로 등록(스프링 빈처럼)
public class Product {
    private int id;
    private String name;
    private int price;
    private  String description;
}
