package com.study.main;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class demo {
    @GetMapping("/demo")
    public String test(){
        log.debug("1111");
        return "demo.html";
    }
}
