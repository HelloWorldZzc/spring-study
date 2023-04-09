package com.example.mybatisplus_plug;

import com.example.mybatisplus_plug.enums.sexEnum;
import com.example.mybatisplus_plug.mapper.userMapper;
import com.example.mybatisplus_plug.pojo.user;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class enumTest {
    @Autowired
    private userMapper userMapper;

    @Test
    public void test01(){
        user u=new user();
        u.setUserAge(99);
        u.setUserName("new index");
        u.setSex(sexEnum.FEMALE);
        userMapper.insert(u);
    }

}
