package com.study.test.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//配置专用设置
@Configuration
public class testConfig {
    @Bean
    public String testMsg(){
        return "bean test message";
    }
}
