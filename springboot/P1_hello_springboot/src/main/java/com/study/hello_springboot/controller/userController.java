package com.study.hello_springboot.controller;

import com.study.hello_springboot.pojo.sql;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class userController {
    //读取配置文件中方式1 单个获取
    @Value("${this.name}")
    private String name;
    @Value("${post}")
    private String post;
    @Value("${likes[1]}")
    private String like;

    //获取所有，在根据需求获取相关的
    @Autowired
    private Environment env;
    //通过java的实体类获取
    @Autowired
    private sql sql;

    @RequestMapping("/")
    public String demo(){
        //测试 yml文件的配置
        System.out.println("配置文件中的 this.name："+name);
        System.out.println("配置文件中的 第2个like："+like);
        System.out.println("配置文件中的 post(拼接而成)："+post);
        System.out.println("配置文件中的 banner(env获取)："+env.getProperty("spring.main.banner-mode"));
        System.out.println("配置文件中的 user(env获取)："+env.getProperty("user[0].name"));
        System.out.println("配置文件中的driver是(class获取): "+sql.getDriverClassName());
        return "demo";
    }
}
