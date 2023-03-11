package com.study.mapper;

import com.study.pojo.user;

import java.util.List;

public interface userMapper {
    //增加用户的操作
    int addUser();
    //修改用户操作
    int updateUser();
    int delete();
    user show_id1();
    List<user> show_all();
}
