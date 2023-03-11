package com.study.mapper;

import com.study.pojo.user;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface userMapper {
    //根据id查询用户信息
    user getUserById(@Param("id") Integer id);
    //查询所有用户信息
    List<user> getUserAll();

    //查询id总和
    Integer getIDSum();
    //查询所有用户--->map集合 因为map集合只能返回一条数据，返回多条会报TooManyResultsException
    //解决方式1--->用一个集合接住
    List<Map<String,String>> getUserTOMap();

    //解决方式2(了解)--->使用@mapkey注解，例如@mapkey(id)，把返回的值，当成1(id)={name:"xxx",age:"xxx"}(返回值) 2={xxx}放到一个map集合中
    @MapKey("id")
    Map<String,Object> getUserTOMap2();
}
