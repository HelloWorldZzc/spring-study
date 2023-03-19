package com.study.mapper;

import com.study.pojo.emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface empMapper {
    //分步查询 第二部
    List<emp> getDeptAndEmpByStepTwo(@Param("deptId") Integer deptId);
}
