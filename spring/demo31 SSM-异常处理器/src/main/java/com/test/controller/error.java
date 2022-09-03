package com.test.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
//解决异常的问题,可以使用到APO思想,但这不用我们使用手写,因为springmvc早就帮我们处理好了
//我们只需要加上这个注解即可
@RestControllerAdvice
public class error {
    @ExceptionHandler
    public result ex(Exception ex){
        System.out.println("嘿嘿,异常你哪里跑！");
        return new result(666,null,"嘿嘿,异常你哪里跑！");
    }
}
