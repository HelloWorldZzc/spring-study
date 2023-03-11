package com.study.mapper;

import com.study.pojo.user;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface specialMapper {
    //通过用户名模糊查询用户信息
    List<user> getUserByLike(@Param("str") String str);

    //批量删除
    void deleteMoreUser(@Param("ids") String ids);

    //设置表名
    List<user> setTableName(@Param("tableName") String tableName);

    //添加用户信息并获取自增的主键
    void insertUser(user u);
}
