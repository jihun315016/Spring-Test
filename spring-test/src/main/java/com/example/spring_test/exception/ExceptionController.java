package com.example.spring_test.exception;

import org.mortbay.io.RuntimeIOException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ExceptionController {
    @GetMapping("/testException1")
    public String testException1() throws NullPointerException, Exception {
        throw new NullPointerException("Null이 들어간 예외");
    }
        
    @ResponseBody
    @GetMapping("/testException2")
    public ResponseEntity<String> testException2() throws RuntimeIOException, Exception {
        throw new RuntimeException("Runtime 예외 발생");
    }
}
