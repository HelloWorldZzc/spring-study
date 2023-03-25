package com.study.pojo;


import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class user{
    Integer id;
    String name;

    public user() {
        System.out.println("生命周期1--->创建对象");
    }

    public user(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        System.out.println("生命周期2--->依赖注入");
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "user{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
    //需要在bean文件中进行配置
    public void init(){
        System.out.println("生命周期初始化阶段");
    }
    public void dead(){
        System.out.println("生命周期死亡阶段");
    }


}
