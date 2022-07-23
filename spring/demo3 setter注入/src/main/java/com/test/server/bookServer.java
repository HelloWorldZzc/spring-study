package com.test.server;

import com.test.dao.bookDao;

public class bookServer {

    //删除业务层中使用new的方式创建的dao对象
    private bookDao bookdao;
    private String name;
    private int age;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void save() {
        System.out.println("book service save ..."+name+"    "+age);
        bookdao.save();
    }
    //没有赋值,写出相关的set方法
    public void setBookdao(bookDao bookdao) {
        this.bookdao = bookdao;
    }
}
