package com.study.mapper;

import com.study.pojo.emp;
import org.apache.ibatis.annotations.Param;

public interface empMapper {
    //根据id查询员工信息(演示类型不匹配问题解决方案)
    emp getEmpByEmpId(@Param("empId") Integer empId);
    //多对一查询（员工与部门之间的关系）--->级联方式--->由于在emp.java中已经写入dept的对象了
    emp getEmpAndDeptJL(@Param("empId") Integer empId);
    //多对一查询（员工与部门之间的关系）--->association属性设置map
    emp getEmpAndDeptByEmpId(@Param("empId") Integer empId);
    //多对一查询（员工与部门之间的关系）--->分步查询
    //通过分步查询查询员工以及所对应的部门信息的第一步
    emp getEmpAndDeptByStepOne(@Param("empId") Integer empId);

}
