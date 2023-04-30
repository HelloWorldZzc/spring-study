package com.study.configpro.pojo;


import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;


//测试不使用@ConfigurationProperties注解，看是否校验规则的类是否能生效

@Validated
public class demo {
    @Max(value = 100,message = "年龄不能超过100")
    @Min(value = 10,message = "年龄不能小于10")
    private int  age;

    public demo(int age) {
        this.age = age;
    }
    public demo(){}

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "demo{" +
                "age=" + age +
                '}';
    }
}
