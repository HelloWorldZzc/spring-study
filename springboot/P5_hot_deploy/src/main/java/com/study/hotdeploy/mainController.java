package com.study.hotdeploy;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class mainController {
    @GetMapping
    public String demoController(){
        System.out.println("demo.....");
        System.out.println("demo27.....");
        System.out.println("demo2100");
        return "demo.html";

    }
}
