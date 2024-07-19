package com.example.spring_test.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ExceptionHandlerSample {
    @ExceptionHandler(NullPointerException.class)
    public ModelAndView nullPointerException(Model mode, NullPointerException ex) {
        mode.addAttribute("ex", ex);
        ModelAndView modelAndView = new ModelAndView("error");
        modelAndView.addObject("errorMessage", ex.getMessage());
        return modelAndView;
    }
    
    // @ExceptionHandler(Exception.class)
    // public String exception(Model mode, Exception ex) {
    //     mode.addAttribute("ex", ex);
    //     System.out.println("exception 발생 =====");
    //     System.out.println(ex.getMessage());
    //     System.out.println("==============================");
    //     return "error";
    // }

    @ExceptionHandler(Exception.class)
    public ModelAndView handleException(Exception ex) {
        ModelAndView modelAndView = new ModelAndView("error");
        modelAndView.addObject("errorMessage", ex.getMessage());
        return modelAndView;
    }
}
