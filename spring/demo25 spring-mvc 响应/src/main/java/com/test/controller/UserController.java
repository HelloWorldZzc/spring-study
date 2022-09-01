package com.test.controller;

import com.test.domain.address;
import com.test.domain.user;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Controller
public class UserController {
    @RequestMapping("/test1")
    //在没有body的标识符的时候,是跳转到某个界面
     public String test1(){
       System.out.println("test1....");
       return "index.jsp";
   }

    //响应文本数据
    //返回值为String类型，设置返回值为任意字符串信息，即可实现返回指定字符串信息，需要依赖@ResponseBody注解
    @RequestMapping("/test2")
    @ResponseBody
    public String toText(){
        System.out.println("返回纯文本数据");
        return "response text";
    }

    //响应POJO对象
    //返回值为实体类对象，设置返回值为实体类类型，即可实现返回对应对象的json数据，需要依赖@ResponseBody注解和@EnableWebMvc注解
    @RequestMapping("/test3")
    @ResponseBody
    public user toJsonPOJO(){
        System.out.println("返回json对象数据");
        user user = new user();
        user.setName("zs");
        address a=new address();
        a.setCity("nc");
        a.setProvince("jx");
        user.setAge(20);
        user.setAddress(a);
        return user;
    }


    //响应POJO集合对象
    //返回值为集合对象，设置返回值为集合类型，即可实现返回对应集合的json数组数据，需要依赖@ResponseBody注解和@EnableWebMvc注解
    @RequestMapping("/test4")
    @ResponseBody
    public List<user> toJsonList(){
        System.out.println("返回json集合数据");
        user user1 = new user();
        user1.setName("zs");
        user1.setAge(15);

        user user2 = new user();
        user2.setName("lisi");
        user2.setAge(12);

        List<user> userList = new ArrayList<user>();
        userList.add(user1);
        userList.add(user2);
        return userList;
    }

}

