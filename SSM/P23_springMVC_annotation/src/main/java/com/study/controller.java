package com.study;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class controller {
    @RequestMapping("/errors/**")
    public String test(){
        System.out.println(1/0);
        return "index";
    }
}
