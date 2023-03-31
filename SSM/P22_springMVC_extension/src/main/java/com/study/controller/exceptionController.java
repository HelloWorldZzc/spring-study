package com.study.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class exceptionController {
    @ExceptionHandler(ArithmeticException.class)
    public String test(Exception ex,Model model){
        model.addAttribute("ex_info",ex);
        return "error";
    }
}
