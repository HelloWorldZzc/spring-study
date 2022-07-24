package com.test.config;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


//标注一下这是spring管的切点
@Component
@Aspect
public class MyAdvice {
    //给什么东西添加切点。。。。
    @Pointcut("execution(void com.test.dao.bookDao.update())")
    private void test(){}
    //在什么时候执行，在test过程之前
    @Before("test()")
    public void method(){
        System.out.println("********");
    }
}
