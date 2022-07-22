package com.test.server;

import com.test.dao.bookDao;

public class bookServer {

    //删除业务层中使用new的方式创建的dao对象
    private bookDao bookdao;
    public void save() {
        System.out.println("book service save ...");
        bookdao.save();
    }
    //没有赋值,写出相关的set方法
    public void setBookdao(bookDao bookdao) {
        this.bookdao = bookdao;
    }


}
