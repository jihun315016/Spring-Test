package com.example.shop.Item;

import org.springframework.data.jpa.repository.JpaRepository;

// 인터페이스를 만들어도 내부적으로 같은 이름을 가진 ItemRepository 클래스를 만들어 줌
// -> 근데 이 클래스 안에는 db 입출력을 도와주는 함수들이 많이 들어있음
// <Entity명, id컬럼 타입>
public interface ItemRepository extends JpaRepository<Item, Long> {

}
