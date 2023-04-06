package com.example.p26_mybatisplus;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.p26_mybatisplus.mapper")
public class P26MybatisPlusApplication {

    public static void main(String[] args) {
        SpringApplication.run(P26MybatisPlusApplication.class, args);
    }

}
