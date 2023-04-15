package com.study.hello_springboot;

import com.study.hello_springboot.pojo.user;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class HelloSpringbootApplication {

    public static void main(String[] args) {
        //我们拿来接收一下这个类返回的内容可以发现是一个context对象
        ConfigurableApplicationContext run = SpringApplication.run(HelloSpringbootApplication.class, args);
        //获取容器了，那么可以尝试着获取bean了
        user bean = run.getBean(user.class);
        //那么可以尝试着输出bean
        System.out.println(bean);
        System.out.println("项目开始启动");
    }

}