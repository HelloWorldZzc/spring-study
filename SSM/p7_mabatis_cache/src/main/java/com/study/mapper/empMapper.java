package com.study.mapper;

import com.study.pojo.emp;
import org.apache.ibatis.annotations.Param;

public interface empMapper {
    //根据员工id查询员工信息
    emp getEmpById(@Param("empId") Integer empId);
    //添加员工信息
    void insertEmp(emp emp);
}
