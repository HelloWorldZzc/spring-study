package com.test.dao;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class bookDao {
    public void save() {
        System.out.println("book dao save ...");
        System.out.println("--------");
    }
    public void update(){
        System.out.println("book dao update");
    }
}
