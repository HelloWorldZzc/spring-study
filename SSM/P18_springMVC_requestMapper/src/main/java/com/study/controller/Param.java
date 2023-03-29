package com.study.controller;
//讲解获取参数的一些方式

import com.study.pojo.user;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;


@Controller
@RequestMapping("/param")
public class Param {
    //使用servletAPI获取请求
    @RequestMapping("/testAPI")
    public String testApi(HttpServletRequest request){
        String name=request.getParameter("name");
        String pwd=request.getParameter("pwd");
        System.out.println("name："+name+",pwd :"+pwd);
        return "success";
    }

    //通过控制器传参的方式获取请求
    @RequestMapping("/controller")
    public String controller(String name,String pwd){
        System.out.println("name："+name+",pwd :"+pwd);
        return "success";
    }

    //通过requestParam注解的方式获取
    @RequestMapping("/request")
    public String request(
            @RequestParam(value = "name",required = true,defaultValue = "admin") String a,
            @RequestParam(value = "pwd",required = false,defaultValue = "pws") String b){
        System.out.println("a: "+a+" b :"+b);
        return "success";
    }

    //获取head相关的信息
    @RequestMapping(value = "/head")
    public String head(@RequestHeader(value = "Referer",required = false) String head){
        System.out.println("head信息："+head);
        return "success";
    }

    //通过实体类Javabean获取参数
    @RequestMapping("/pojo")
    public String pojo(user user){
        System.out.println(user);
        return "success";

    }



}
