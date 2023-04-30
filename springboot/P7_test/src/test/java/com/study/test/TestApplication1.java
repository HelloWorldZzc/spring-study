package com.study.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(
        args = "--config.temp_prop='springboot test2....'",
        properties = "config.temp_prop='springboot test1....'"
)
class TestApplication1 {

    @Value("${config.temp_prop}")
    private String temp_prop;

    @Test
    public void propTest(){
        System.out.println("temp_prop："+temp_prop);

    }
}
