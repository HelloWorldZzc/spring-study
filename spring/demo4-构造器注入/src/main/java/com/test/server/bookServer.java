package com.test.server;

import com.test.dao.bookDao;

public class bookServer {

    //删除业务层中使用new的方式创建的dao对象
    private bookDao bookdao;
    private String name;
    private int age;



    public void save() {
        System.out.println("book service save ..."+name+"   "+age);
        bookdao.save();
    }
    //使用构造器的方式,完成依赖注入
    public bookServer(bookDao bookdao, String name, int age) {
        this.bookdao = bookdao;
        this.name = name;
        this.age = age;
    }
}
