package com.study.configpro;

import com.study.configpro.pojo.Sconfig;
import com.study.configpro.pojo.demo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ConfigProApplicationTests {
    @Autowired
    private Sconfig sconfig;

    @Test
    //测试使用时间、空间变量输出
    public void test1(){
        System.out.println(sconfig);
    }

}
