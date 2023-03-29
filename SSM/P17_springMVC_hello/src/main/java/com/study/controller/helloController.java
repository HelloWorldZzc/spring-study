package com.study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class helloController {
    @RequestMapping("/")
    public String index(){
        return "index.html";
    }
    @RequestMapping("/hello")
    public String hello(){
        return "success";
    }
}
