package com.example.mybatisplus_plug.pojo;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.example.mybatisplus_plug.enums.sexEnum;
import lombok.Data;

@Data
@TableName("user_mybatis_plus")
public class user {

    @TableId(value = "id")
    private Long userId;
    @TableField("name")
    private String userName;
    @TableField("age")
    private Integer userAge;
    @TableField("email")
    private String userEmail;
    @TableField("sex")
    private sexEnum sex;

}
