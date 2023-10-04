package com.study.credis.controller;


import com.study.credis.service.smsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @DeleteMapping("/")
    public String deleteCode(String tel){
        service.delete(tel);
        return "ok";
    }

}
