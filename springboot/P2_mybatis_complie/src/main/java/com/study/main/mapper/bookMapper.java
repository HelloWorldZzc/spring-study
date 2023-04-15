package com.study.main.mapper;

import com.study.main.pojo.book;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface bookMapper {
    @Select("select * from book")
    public List<book> selectAll();

    public book selectById(int id);

}
