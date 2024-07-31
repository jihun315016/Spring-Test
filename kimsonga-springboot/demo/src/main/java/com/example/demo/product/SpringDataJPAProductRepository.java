package com.example.demo.product;

import org.springframework.data.jpa.repository.JpaRepository;

// Spring Data JPA : 스프링이 제공해주는 JPA 인터페이스
// -> JPA를 추상화한 거 -> 추상화했다는 건 뒤에거 몰라도 돼, 나만보면 알아서 쓰게해줄게
// -> JPA 메서드가 좀 더 간결해지고 많아짐

public interface SpringDataJPAProductRepository extends JpaRepository<Product, Integer> {
}
