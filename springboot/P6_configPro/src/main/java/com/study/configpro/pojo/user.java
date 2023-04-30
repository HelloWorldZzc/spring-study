package com.study.configpro.pojo;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@Data
@ConfigurationProperties(prefix = "config")
public class user {
    private String name;
    private int age;
    private String sex;
}
