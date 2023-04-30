package com.study.configpro;

import com.study.configpro.pojo.demo;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
public class controller {
    @PostMapping("/")
    public String post(@Validated @RequestBody demo demo){
        //使用postman raw json属性
        return "post 接收到的参数(demo)age："+demo.getAge();
    }

    @GetMapping("/")
    public String get(@Validated demo demo){
        // 使用postman params
        return "get 接收到的参数age："+demo.getAge();
    }

}
