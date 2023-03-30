package com.study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

//视图控制器
@Controller
public class TestViewController {
    @RequestMapping("/testTemp")
    public String Temp(){
        return "success";
    }

    //转发视图(了解 几乎不用)
    @RequestMapping("/testForward")
    public String testForward(){
        return "forward:/testTemp";
    }

    //重定向视图
    @RequestMapping("/testRedirect")
    public String redirect(){
        return "redirect:/testTemp";
    }
    //重定向需要参数实现？
    @RequestMapping("/a")
    public String a(@RequestParam(value = "username") String username){
        System.out.println("username: "+username);
        return "success";
    }
    @RequestMapping("/b")
    public String b(){
        return "redirect:/a?username=123";
    }


}
