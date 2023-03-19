package com.study.mapper;
import com.study.pojo.dept;
import org.apache.ibatis.annotations.Param;

public interface deptMapper {

    //多对一查询--->分步查询 第二步
    dept getEmpAndDeptByStepTwo(@Param("id")Integer deptId);
}
