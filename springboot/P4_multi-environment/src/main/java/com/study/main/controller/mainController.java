package com.study.main.controller;

import lombok.extern.slf4j.Slf4j;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@Slf4j
public class mainController {
    //private static final Logger log=LoggerFactory.getLogger(mainController.class);
    @GetMapping("/")
    public String main(){
        System.out.println("springboot running....");
        log.info("info....");
        log.warn("warn....");
        log.debug("debug....");
        log.error("error....");
        return "demo";
    }
}
