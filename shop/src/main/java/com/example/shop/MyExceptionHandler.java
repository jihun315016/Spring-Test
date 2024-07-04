package com.example.shop;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@ControllerAdvice
public class MyExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handler() {
        // 존재하는 모든 컨트롤러에서 에러가 나는 경우에 이 코드 실행
        return ResponseEntity.status(400).body("파라미터 타입 안 맞아서 에러남");
    }
    
    // 파라미터 타입 안 맞는 에러
    // 이런식으로 특정 에러에 대해서만 처리할 수도 있음
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<String> handler1() {
        // 존재하는 모든 컨트롤러에서 에러가 나는 경우에 이 코드 실행
        return ResponseEntity.status(400).body("에러남");
    }
}
