package com.test.dao;

import com.test.domain.book;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface bookDao {
    @Insert("insert into book (type,name,description) values(#{type},#{name},#{description})")
    public void save(book book);

    @Update("update book set type = #{type}, name = #{name}, description = #{description} where id = #{id}")
    public void update(book book);

    @Delete("delete from book where id = #{id}")
    public void delete(Integer id);

    @Select("select * from book where id = #{id}")
    public book getById(Integer id);

    @Select("select * from book")
    public List<book> getAll();
}
