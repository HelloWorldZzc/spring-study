package com.example.mybatisplus_plug;

import com.example.mybatisplus_plug.mapper.userMapper;
import com.example.mybatisplus_plug.pojo.user;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

//测试程序是否能正常运行
@SpringBootTest
public class demoTest {
    @Autowired
    private userMapper userMapper;


    @Test
    public void test(){
        List<user> users = userMapper.selectList(null);
        users.forEach(System.out::println);

    }

}
