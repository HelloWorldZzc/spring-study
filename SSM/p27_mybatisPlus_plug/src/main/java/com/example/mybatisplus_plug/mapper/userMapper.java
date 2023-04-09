package com.example.mybatisplus_plug.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mybatisplus_plug.pojo.user;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface userMapper extends BaseMapper<user> {
   Page<user> selectPageDIY(@Param("page") Page<user> page,@Param("age") Integer age);
}
