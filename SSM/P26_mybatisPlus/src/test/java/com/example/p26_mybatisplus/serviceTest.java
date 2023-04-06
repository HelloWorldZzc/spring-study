package com.example.p26_mybatisplus;

import com.example.p26_mybatisplus.pojo.user;
import com.example.p26_mybatisplus.service.userService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

@SpringBootTest
public class serviceTest {

    @Autowired
    private userService userService;

    @Test
    //查询总数
    public void getCount(){
        long count = userService.count();
        System.out.println("数据库中的总数为："+count);
    }

    //批量插入
    @Test
    public void saveAll(){
        ArrayList<user> list = new ArrayList<>();
        for (int i=0;i<5;i++){
            user u=new user();
            u.setName("name"+i);
            list.add(u);
        }
        //批量添加
        boolean b = userService.saveBatch(list);
        System.out.println("添加："+b);
    }


}
