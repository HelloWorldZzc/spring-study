package com.study.mapper;
import com.study.pojo.user;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

public interface userMapper {
    //根据用户名查询用户信息
    user getUserByUsername(String username);
    //验证登录
    user checkLogin(String username, String password);
    //验证登录（以map集合作为参数）
    user checkLoginByMap(Map<String, String> map);
    //添加用户信息 创建一个user对象
    void insertUser(user u);
    //添加用户信息plus 创建两个user对象测试
    void insertUserPlus(user u1,user u2);
    //验证登录（使用@Param）
    user checkLoginByParam(@Param ("name") String username,@Param("pwd") String password);
    //test
    void add(@Param("p1") user u1,@Param("p2") user u2);
}
