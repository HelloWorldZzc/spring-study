package com.study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//为了保证在测试的时候不会报404错误，因此所有的界面都指定跳转路径
@Controller
public class viewController {
    @RequestMapping("/*")
    public String test(){
        return "success";
    }

    @RequestMapping("/error/*")
    public String error(){
        System.out.println(1/0);
        return "success";
    }

}
