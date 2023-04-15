package com;

import com.study.main.MybatisApplication;
import com.study.main.mapper.bookMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = MybatisApplication.class)
public class demoTest {
    @Autowired
    bookMapper bookMapper;
    @Test
    public void test1(){
        System.out.println(bookMapper.selectById(1));
    }
}
