package com.study.test;

import com.study.test.pojo.user;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class controller {
    @RequestMapping("/")
    public String demo(){
        System.out.println("控制台输出内容:demo");
        return "return返回内容：demo....";
    }
    @RequestMapping("/user")
    public user demo2(){
        user u=new user();
        u.setName("zs");
        return u;
    }

}
