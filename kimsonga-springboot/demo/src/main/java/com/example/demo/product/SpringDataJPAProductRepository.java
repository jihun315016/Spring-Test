package com.example.demo.product;

import org.springframework.data.jpa.repository.JpaRepository;

// Spring Data JPA : 스프링이 제공해주는 JPA 인터페이스
// -> JPA를 추상화한 거 -> 추상화했다는 건 뒤에거 몰라도 돼, 나만보면 알아서 쓰게해줄게
// -> JPA 메서드가 좀 더 간결해지고 많아짐
//  "추상화"라는 의미는 JPA의 세부 구현을 숨기고, 개발자가 더 간편하게 사용할 수 있도록 다양한 기능을 제공한다는 것
// JpaRepository를 상속받으면 인터페이스 기반으로 추상화된 메서드를 제공받을 수 있다.
public interface SpringDataJPAProductRepository extends JpaRepository<Product, Integer> { }
