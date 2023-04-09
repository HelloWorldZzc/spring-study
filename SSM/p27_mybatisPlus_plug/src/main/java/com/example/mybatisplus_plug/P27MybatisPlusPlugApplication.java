package com.example.mybatisplus_plug;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.mybatisplus_plug.mapper")
public class P27MybatisPlusPlugApplication {

    public static void main(String[] args) {
        SpringApplication.run(P27MybatisPlusPlugApplication.class, args);
    }

}
