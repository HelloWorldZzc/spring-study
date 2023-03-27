package com.study.server;

import com.study.Calculator;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class ProxyFactory {
    //创建动态代理
    private Calculator calculator;

    public ProxyFactory(Calculator calculator) {
        this.calculator = calculator;
    }

    public Object getProxy(){
        //在javaEE的课程中也有提到哦，当时觉得比较难懂，现在应该更简单了，全都是反射的知识点
       return Proxy.newProxyInstance(
                ProxyFactory.class.getClassLoader(),
                calculator.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        Object result=null;
                       try {
                           System.out.println("日志，方法："+method.getName()+"，参数："+ Arrays.toString(args));
                           result = method.invoke(calculator, args);
                           System.out.println("日志，方法："+method.getName()+"，结果："+ result);

                       }catch (Exception e){
                           e.printStackTrace();
                           System.out.println("日志，方法："+method.getName()+"，异常："+ e);
                       }finally {
                           System.out.println("日志，方法："+method.getName()+"，方法执行完毕");
                       }
                        return result;
                    }

                }


        );

    }
}
