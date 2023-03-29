package com.study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class mainController {
    //初始化
    @RequestMapping("/")
    public String index(){
        return "index";
    }
    //检测value属性
    @RequestMapping(value = {"/go","/success"})
    public String go(){
        return "success";
    }

    //检测method属性
    @RequestMapping(value = "/get",method = {RequestMethod.GET})
    public String method_get(){
        return "success";
    }
    //使用派生注解 简化一些操作
    @PostMapping("/post")
    public String method_post(){
        return "success";
    }

    //params属性
    @RequestMapping(value = "/params",params = {"username","password=123"})
    public String params(){
        return "success";
    }

    //header属性
    @RequestMapping(value = "/head",headers = {"Referer=http://localhost:8080/temp/"})
    public String header(){
        return "success";
    }
    //ant风格
    @RequestMapping({"/a?a","b*b","a/**/test"})
    public String ant(){
        return "success";
    }
    //占位符
    @RequestMapping("user/{type}/{id}")
    public String add(@PathVariable("id") Integer id,@PathVariable("type") String type){
        System.out.println("此方法收到的id:"+id+"操作类型为："+type);
        return "success";
    }

}
