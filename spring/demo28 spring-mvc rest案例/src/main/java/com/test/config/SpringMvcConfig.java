package com.test.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

//springmvc配置类，本质上还是一个spring配置类
@Configuration
@ComponentScan("com.test")
@EnableWebMvc
public class SpringMvcConfig {}
