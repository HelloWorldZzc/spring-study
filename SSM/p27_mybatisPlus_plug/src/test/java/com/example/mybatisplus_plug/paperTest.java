package com.example.mybatisplus_plug;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mybatisplus_plug.mapper.userMapper;
import com.example.mybatisplus_plug.pojo.user;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class paperTest {

    @Autowired
    private userMapper userMapper;

    //测试分页插件
    @Test
    public void testPage(){
        //创建一个分页插件
        Page<user> page = new Page<>(1,5);
        //获取数据(数据存入paper中)
        userMapper.selectPage(page,null);
        //获取paper中的参数
        List<user> list = page.getRecords();
        list.forEach(System.out::println);
        System.out.println("当前页："+page.getCurrent());
        System.out.println("每页显示的条数："+page.getSize());
        System.out.println("总记录数："+page.getTotal());
        System.out.println("总页数："+page.getPages());
        System.out.println("是否有上一页："+page.hasPrevious());
        System.out.println("是否有下一页："+page.hasNext());

    }

    @Test
    public void testPageDIY(){
        Page<user> page=new Page<>(1,3);
        userMapper.selectPageDIY(page, 30);
        List<user> list = page.getRecords();
        list.forEach(System.out::println);
        System.out.println("当前页："+page.getCurrent());
        System.out.println("每页显示的条数："+page.getSize());
        System.out.println("总记录数："+page.getTotal());
        System.out.println("总页数："+page.getPages());
        System.out.println("是否有上一页："+page.hasPrevious());
        System.out.println("是否有下一页："+page.hasNext());
    }
}
