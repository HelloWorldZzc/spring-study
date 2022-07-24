package com.test.dao;

import org.springframework.stereotype.Component;

@Component("bookdao")
public class bookDao {
    public void save() {
        System.out.println("book dao save ...");
    }
}
