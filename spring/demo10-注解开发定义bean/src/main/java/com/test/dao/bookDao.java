package com.test.dao;

import org.springframework.stereotype.Component;

//这个注解没有写明相关的类,那获取bean的方式只能使用xxx.class方式来获取(参考前面学习的bean的获取方式)
@Component
public class bookDao {
    public void save(){
        System.out.println("bookDao...");
    }
}
