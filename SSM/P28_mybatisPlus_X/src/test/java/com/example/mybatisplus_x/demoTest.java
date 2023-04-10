package com.example.mybatisplus_x;

import com.example.mybatisplus_x.mapper.userMapper;
import com.example.mybatisplus_x.pojo.user;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class demoTest {

   @Autowired
   private userMapper userMapper;

    @Test
    //测试添加
    public void test(){
        user u=new user();
        u.setAge(200);
        u.setId(90L);
        u.setName("自动生成");
        int i = userMapper.insertSelective(u);
        System.out.println("添加结果："+i);
    }

    @Test
    public void test1(){
        List<user> users = userMapper.selectList(null);
        users.forEach(System.out::println);
    }

    @Test
    //delByAgeBetween
    public void test2(){
        userMapper.delByAgeBetween(100,200);
    }

    @Test
    //updateAgeAndEmail
    public void test3(){
        userMapper.updateAgeAndEmail(200,"update");
    }

    @Test
    //searchByIdEquals
    public void test4(){
        List<user> users = userMapper.searchByIdEquals(2L);
        users.forEach(System.out::println);
    }

}
