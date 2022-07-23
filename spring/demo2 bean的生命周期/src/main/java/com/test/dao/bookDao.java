package com.test.dao;

public class bookDao {
    public void save() {
        System.out.println("book dao save ...");
    }
    //表示bean初始化对应的操作
    public void init(){
        System.out.println("init...");
    }
    //表示bean销毁前对应的操作destroy
    public void destroy(){
        System.out.println("destroy...");
    }
}
