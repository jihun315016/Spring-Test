package com.example.shop.member;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long>
{
    // findBy컬럼명(어쩌구) 또는 findAllBy컬럼명(어쩌구) -> 하나만 찾거나 조건맞는거 전부 찾거나
    // 이렇게 쓰면 이걸보고 진짜로 이 데이터를 찾아주는 함수를 만들어 줌
    // 이런걸 멋있는 말로 Derived query method라고 부름
    // 정렬하고 조건주고 이상, 이하같은것도 할 수 있음
    Optional<Member> findByUsername(String name);
}
