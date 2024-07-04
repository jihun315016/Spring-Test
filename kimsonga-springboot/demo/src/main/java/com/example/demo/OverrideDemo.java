package com.example.demo;

public class OverrideDemo {
    void test() {
        Child child = new Child();
        child.method();
    }
}

class Parent {
    void method() {

    }
}

class Child extends Parent {
    // @Override가 없다면 만약 metod()와 같이 오타를 냈을 때 실수로 그냥 넘어살 수 있다.
    // 자바에서 어노테이션은 컴파일러가 잘못된 게 있는지 봐주는 역할 같은걸 하는 것이다.
    @Override
    void method() {

    }
}