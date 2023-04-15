package com.study.hello_springboot.pojo;


import org.springframework.stereotype.Component;

@Component
public class user {
    private int id;
    private int age;

    @Override
    public String toString() {
        return "user{" +
                "id=" + id +
                ", age=" + age +
                '}';
    }
}
