package com.example.spring_test.exception;

import org.mortbay.io.RuntimeIOException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestExceptionController {
    @GetMapping("/testException3")
    public ResponseEntity<String> testException3() throws RuntimeIOException, Exception {
        throw new RuntimeException("Runtime 예외 발생");
    }
}
