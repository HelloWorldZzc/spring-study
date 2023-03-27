package com.study.aop_an;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

//设置一个切面类
@Component
@Aspect
public class LogAspect {
    //这样的话 配置一条就能应用于全局，比较方便
    @Pointcut("execution(public int com.study.aop_an.CalculatorPureImpl.*(..))")
    public void demo_execution(){}

    //前置通知
    @Before("execution(public int com.study.aop_an.CalculatorPureImpl.*(..))")
    public void before(JoinPoint joinPoint){
        //获取签名，签名中有很多的信息
        String methodName=joinPoint.getSignature().getName();
        String args=Arrays.toString(joinPoint.getArgs());
        System.out.println("Logger--->前置通知，方法名"+methodName+"参数："+args);
    }

    //后置通知
    @After("demo_execution()")
    public void after(JoinPoint joinPoint){
        String methodName=joinPoint.getSignature().getName();
        System.out.println("logger--->后置通知，方法名："+methodName);
    }

    //异常通知--->接受异常的参数 需要用throwing="x"指定，在下面才能输出
    @AfterThrowing(value = "demo_execution()",throwing = "e")
    public void throwing(JoinPoint joinPoint,Exception e){
        String methodName=joinPoint.getSignature().getName();
        System.out.println("Logger--->异常通知，方法名："+methodName+"异常："+e);
    }
    //返回通知---> 使用returning关键字 用来表示返回值
    @AfterReturning(value = "demo_execution()",returning = "result")
    public void returning(JoinPoint joinPoint,Object result){
        String methodName = joinPoint.getSignature().getName();
        System.out.println("Logger-->返回通知，方法名："+methodName+"，结果："+result);
    }

}
