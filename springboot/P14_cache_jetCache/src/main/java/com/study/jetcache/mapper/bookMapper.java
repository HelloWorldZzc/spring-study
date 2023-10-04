package com.study.jetcache.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.study.jetcache.pojo.book;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface bookMapper extends BaseMapper<book> {
}
