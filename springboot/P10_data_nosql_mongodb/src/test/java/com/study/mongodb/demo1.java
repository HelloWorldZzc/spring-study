package com.study.mongodb;


import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
public class demo1 {
    @Resource
    MongoTemplate mongoTemplate;

    //创建MongoDB相关案例
    @Test
    public void test1(){
        book b=new book();
        b.setId("1");
        b.setName("html");
        b.setType("前端");
        b.setDescription("描述....");
        mongoTemplate.save(b);
    }

    @Test
    public void test2(){
        List<book> all = mongoTemplate.findAll(book.class);
        all.forEach(System.out::println);
    }
}
