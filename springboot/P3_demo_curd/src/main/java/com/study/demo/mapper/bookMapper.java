package com.study.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.study.demo.pojo.book;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface bookMapper extends BaseMapper<book> {

}
