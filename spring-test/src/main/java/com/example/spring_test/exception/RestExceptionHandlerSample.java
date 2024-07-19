package com.example.spring_test.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestExceptionHandlerSample {
    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<Object> nullPointerException(Model mode, NullPointerException ex) {
        mode.addAttribute("ex", ex);
        System.out.println("Rest nullPointerException 발생 =====");
        System.out.println(ex.getMessage());
        System.out.println("==============================");
        return ResponseEntity.badRequest().body("Rest nullPointerException 발생");
    }
    
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> exception(Model mode, Exception ex) {
        mode.addAttribute("ex", ex);
        System.out.println("Rest exception 발생 =====");
        System.out.println(ex.getMessage());
        System.out.println("==============================");
        return ResponseEntity.badRequest().body("Rest exception 발생");
    }    
}

