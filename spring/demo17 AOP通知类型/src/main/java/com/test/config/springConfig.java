package com.test.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("com.test")
//告诉spring有切点了需要管理
@EnableAspectJAutoProxy
public class springConfig {
}
