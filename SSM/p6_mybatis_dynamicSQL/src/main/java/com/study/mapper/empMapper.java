package com.study.mapper;

import com.study.pojo.emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface empMapper {
    //条件不定可以直接使用 where 1=1 and xxx and xxx这样直接使用if完成

    //根据条件查询员工信息（条件不定）--->if where
    List<emp> getEmpByCondition(emp emp);
    //根据条件查询员工信息（条件不定）--->if trim
    List<emp> getEmpByCondition2(emp emp);
    //根据条件查询员工信息（条件不定）---->choose、when、otherwise
    List<emp> getEmpByCondition3(emp emp);

    //批量添加 foreach
    void insertMoreEmp(@Param("emps") List<emp> emps);

    //批量删除
    void deleteMoreEmp(@Param("empIds") Integer[] empIds);
}
