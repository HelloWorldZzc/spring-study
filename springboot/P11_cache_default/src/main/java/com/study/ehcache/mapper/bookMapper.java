package com.study.ehcache.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.study.ehcache.pojo.book;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface bookMapper extends BaseMapper<book> {
}
