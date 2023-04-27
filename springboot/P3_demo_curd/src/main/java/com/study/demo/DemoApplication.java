package com.study.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        //展示一下传入的参数
        System.out.println(Arrays.toString(args));
        //自定义传入参数
        //String[] arg=new String[1];
        //arg[0]="--server.port=8088";
        SpringApplication.run(DemoApplication.class, args);
    }

}
