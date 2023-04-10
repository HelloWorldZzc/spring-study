package com.example.mybatisplus_x;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.mybatisplus_x.mapper")
public class P28MybatisPlusXApplication {

    public static void main(String[] args) {
        SpringApplication.run(P28MybatisPlusXApplication.class, args);
    }

}
