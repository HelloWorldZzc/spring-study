package com.test.dao;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class bookDao {
    public void save() {
        System.out.println("book dao save ...");
    }
    public int update(int i){
        System.out.println("book dao update"+i);
        return i;
    }
}
