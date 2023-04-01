package com.study.ssm.mapper;

import com.study.ssm.pojo.Employee;
import java.util.List;

//mybatis中的mapper接口
public interface EmployeeMapper {
    List<Employee> getAllEmployee();
}
