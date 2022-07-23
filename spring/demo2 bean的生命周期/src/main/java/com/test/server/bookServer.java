package com.test.server;

import com.test.dao.bookDao;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class bookServer implements InitializingBean, DisposableBean {

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

    @Override
    public void destroy() throws Exception {
        System.out.println("destroy in server");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("init in server");
    }
}
