package com.study.test;

import com.study.test.pojo.book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestApplication4 {
    //测试随机数测试案例
    @Autowired
    private book b;
    @Test
    public void test(){
        System.out.println(b);
    }
}
