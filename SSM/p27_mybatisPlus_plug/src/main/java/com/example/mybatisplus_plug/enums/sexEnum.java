package com.example.mybatisplus_plug.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.Getter;

//创建枚举
@Getter
public enum sexEnum {

    MALE(1,"男"),
    FEMALE(2,"女");

    @EnumValue
    //指定这个值 是存储与数据库中的
    private Integer sex;
    private String sexName;

    sexEnum(Integer sex, String sexName) {
        this.sex = sex;
        this.sexName = sexName;
    }
}
