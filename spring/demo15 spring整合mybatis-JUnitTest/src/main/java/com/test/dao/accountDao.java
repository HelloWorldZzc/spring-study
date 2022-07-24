package com.test.dao;

import com.test.domain.account;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface accountDao {
    @Insert("insert into account(name,money)values(#{name},#{money})")
    void save(account account);

    @Delete("delete from account where id = #{id} ")
    void delete(Integer id);

    @Update("update account set name = #{name} , money = #{money} where id = #{id} ")
    void update(account account);

    @Select("select * from account")
    List<account> findAll();

    @Select("select * from account where id = #{id} ")
    account findById(Integer id);
}