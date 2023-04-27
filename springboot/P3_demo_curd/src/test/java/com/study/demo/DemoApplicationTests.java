package com.study.demo;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.study.demo.mapper.bookMapper;
import com.study.demo.pojo.book;
import com.study.demo.service.bookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    private bookMapper bookMapper;

    @Autowired
    private bookService bookService;

    @Test
    //测试案例时候跑通
    public void test1(){
        System.out.println(bookMapper.selectById(1));
    }

    @Test
    public void test2(){
        book b=new book();
        b.setDescription("ok");
        IPage<book> page = bookService.getPage(1, 5, b);
        System.out.println(page);
    }
}
