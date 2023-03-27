package com.study.aop_xml;

import org.aspectj.lang.JoinPoint;
import org.springframework.stereotype.Component;

import java.util.Arrays;

//设置一个切面类
@Component
public class LogAspect_xml {
    public void before(JoinPoint joinPoint){
        //获取签名，签名中有很多的信息
        String methodName=joinPoint.getSignature().getName();
        String args=Arrays.toString(joinPoint.getArgs());
        System.out.println("Logger--->前置通知，方法名"+methodName+"参数："+args);
    }

    public void after(JoinPoint joinPoint){
        String methodName=joinPoint.getSignature().getName();
        System.out.println("logger--->后置通知，方法名："+methodName);
    }

    public void throwing(JoinPoint joinPoint,Exception e){
        String methodName=joinPoint.getSignature().getName();
        System.out.println("Logger--->异常通知，方法名："+methodName+"异常："+e);
    }
    public void returning(JoinPoint joinPoint,Object result){
        String methodName = joinPoint.getSignature().getName();
        System.out.println("Logger-->返回通知，方法名："+methodName+"，结果："+result);
    }

}
