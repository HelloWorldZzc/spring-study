package com.study.ssm.service;

import com.github.pagehelper.PageInfo;
import com.study.ssm.pojo.Employee;

import java.util.List;

public interface EmployeeService {
    //查询所有员工的信息
    List<Employee> getAllEmployee();
    //查询分页员工的信息
    PageInfo<Employee> getEmployeePage(Integer pageNum);
}
