package com.test.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * 这是通知类型，写的有点杂，但是总结起来，主要是5个
 * 前置通知
 * 后置通知
 * 返回后通知
 * 异常后通知--->这些都是通过字面意思就能理解的，但用不多，主要使用环绕通知
 *
 * 环绕通知
 *  在xx执行的时候开始，在xx后的时候执行
 *  中间使用 ProceedingJoinPoint p p.process()表示源代码的执行
 *  不过注意，要自己来处理相关的异常
 *
 *  tip：
 *      要是是返回类型（非void类型）
 *      需要使用return将相关的值进行返回，类型呢需要使用object
 *      更确切的说，void的时候也能这样写，返回的值是null
 *      类型中的原始数据能使用  Object obj=p.proceed();来接收
 *      此return是返回一个新的数据，作为这个函数的返回值
 *      写的不好，有点难理解，多练习就行
 *
 */

@Component
@Aspect
public class MyAdvice {

    @Pointcut("execution(* com..bookDao.up*(..))")
    private void test1(){}

    @Pointcut("execution(* com..bookDao.save*(..))")
    private void test2(){}

    @Before("test1()")
    public void method(){
        System.out.println("****test1-method****");
    }

    @After("test2()")
    public void method2(){
        System.out.println("****test2-method2****");
    }
    @Around("test1()")
    public Object method3(ProceedingJoinPoint p) throws Throwable{
        System.out.println("around1");
        Object obj=p.proceed();
        System.out.println("原始的数据"+obj);
        System.out.println("around2");
        return 200;
    }

    @Around("test2()")
    public void method4(ProceedingJoinPoint p) throws Throwable{
        System.out.println("around1");
        p.proceed();

        System.out.println("around2");

    }

    @AfterReturning("test1()")
    public void method5(){
        System.out.println("返回后通知");
    }
    @AfterThrowing("test1()")
    public void method6(){
        System.out.println("异常后通知");
    }

}
