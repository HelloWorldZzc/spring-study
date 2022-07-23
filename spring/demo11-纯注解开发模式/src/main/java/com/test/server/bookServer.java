package com.test.server;
import org.springframework.stereotype.Component;
@Component("bookServer")
public class bookServer {
    //删除业务层中使用new的方式创建的dao对象
    public void save() {
        System.out.println("book service save ...");
    }
}
