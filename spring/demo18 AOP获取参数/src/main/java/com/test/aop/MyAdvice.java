package com.test.aop;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import java.util.Arrays;


@Component
@Aspect
public class MyAdvice {
    @Pointcut("execution(* com.test.dao.bookDao.findName(..))")
    private void pt(){}

    //使用JoinPoint jp,使用这样的方式来获取相关的参数类型
    //最高原则:使用jp,他一定需要放在第一个参数里面
    //@Before("pt()")
    public void test0(JoinPoint jp){
        Object[] ob=jp.getArgs();
        System.out.println(Arrays.toString(ob));
    }

    //使用了ProceedingJoinPoint能直接获取相关的参数值
   // @Around("pt()")
    public Object test(ProceedingJoinPoint pjp){
        Object[] args = pjp.getArgs();
        System.out.println(Arrays.toString(args));
        //使用了ProceedingJoinPoint,在proceed的时候要是传入参数,那就会带着此时的参数进行函数执行
        //所以在这里我们能修改相关的参数
        args[0]=666;
        Object o= null;
        try {
            o = pjp.proceed(args);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return o;

    }
    //设置返回值--->在异常之后,基本上是很少用到,了解即可
    @AfterThrowing(value = "pt()",throwing = "t")
    public void test1(Throwable t){
        System.out.println("after Throwing..."+t);
    }

    //设置返回后通知获取返回值
    @AfterReturning(value = "pt()",returning = "ret")
    public void test2(JoinPoint jp,String ret){
        System.out.println("afterReturning..."+ret);
    }
}
