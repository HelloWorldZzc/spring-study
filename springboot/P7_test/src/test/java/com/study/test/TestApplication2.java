package com.study.test;

import com.study.test.config.testConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Import;

@SpringBootTest
//使用import注释加载当前测试类专用的配置
@Import({testConfig.class})
public class TestApplication2 {
    @Autowired
    private String msg;
    @Autowired
    private ApplicationContext context;

    @Test
    public void test1(){
        System.out.println("获取的spring容器："+context);
        System.out.println("msg: "+msg);
    }
}
