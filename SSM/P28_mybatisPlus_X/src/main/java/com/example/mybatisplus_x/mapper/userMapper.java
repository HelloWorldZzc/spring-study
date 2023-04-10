package com.example.mybatisplus_x.mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.mybatisplus_x.pojo.user;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
* @author ASUS
* @description 针对表【user_mybatis_plus】的数据库操作Mapper
* @createDate 2023-03-30 22:41:28
* @Entity com.example.mybatisplus_x.pojo.user
*/
@Component
public interface userMapper extends BaseMapper<user> {
    //增
    int insertSelective(user user);
    //删
    int delByAgeBetween(@Param("beginAge") Integer beginAge, @Param("endAge") Integer endAge);
    //改
    int updateAgeAndEmail(@Param("age") Integer age, @Param("email") String email);
    //查
    List<user> searchByIdEquals(@Param("id") Long id);



}




