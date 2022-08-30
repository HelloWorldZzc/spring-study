package com.test.dao;


import org.springframework.stereotype.Component;

@Component
public class bookDao {
    public String findName(int id,String password){
        System.out.println("id:   "+id);
        //int i=1/0;
        return "this is a test";
    }

}
