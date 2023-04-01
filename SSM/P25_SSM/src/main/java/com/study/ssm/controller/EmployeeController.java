package com.study.ssm.controller;

import com.github.pagehelper.PageInfo;
import com.study.ssm.pojo.Employee;
import com.study.ssm.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value = "/emp/page/{num}",method = RequestMethod.GET)
    public String getEmpPage(@PathVariable("num") Integer pageNum, Model model){
        //获取分页员工信息
        PageInfo<Employee> page = employeeService.getEmployeePage(pageNum);
        model.addAttribute("page",page);
        System.out.println("page--------------->"+page.getList());
        return "emp_info";
    }

    //之前展示所有剩下的，现在没有地方在使用了
    @RequestMapping(value = "/emp",method = RequestMethod.GET)
    public String getAll(Model model){
        List<Employee> list = employeeService.getAllEmployee();
        model.addAttribute("list",list);
        System.out.println("list---------------->"+list);
        return "emp_info";

    }

}
