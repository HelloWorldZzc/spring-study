package com.study.aop_an;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

//四种通知结合到一起
//指定切面的优先级
@Order(1000)
@Aspect
@Component
public class LogAspect_all {
    @Around("execution(public int com.study.aop_an.CalculatorPureImpl.*(..))")
    public Object test_around(ProceedingJoinPoint proceedingJoinPoint){
        String methodName=proceedingJoinPoint.getSignature().getName();
        String args= Arrays.toString(proceedingJoinPoint.getArgs());
        Object result=null;
        try {
            System.out.println("环绕通知--->目标对象方法执行之前");
            result = proceedingJoinPoint.proceed();
            System.out.println("环绕通知--->目标对象执行之后");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            System.out.println("环绕通知--->目标对象方法出现异常时");
        }finally {
            System.out.println("环绕通知--->目标对象执行完毕");
        }
        return result;
    }
}
