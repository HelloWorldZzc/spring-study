package com.study.mapper;

import com.study.pojo.dept;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface deptMapper {
    //查询部门 及部门内员工信息---->collection关键字
    dept getDeptAndEmpByDeptId(@Param("deptId") Integer deptId);
    //查询部门 及部门内员工信息---->分步查询
    dept getDeptAndEmpByStepOne(@Param("deptId") Integer deptId);
}
