package com.study.jetcache.controller;


import com.study.jetcache.service.smsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sms")
public class smsController {
//测试发送验证码程序
    @Autowired
    private smsService service;


    @GetMapping("/")
    public String sendCode(String tel){
        return service.sendCode(tel);
    }

    @PostMapping("/")
    public boolean checkCode(String tel,String code){
        return service.checkCode(tel,code);
    }

}
