package com.study.controller;

import com.study.dao.EmployeeDao;
import com.study.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Collection;

@Controller
public class EmployeeController {
    @Autowired
    EmployeeDao employeeDao;

    //查询所有
    @RequestMapping(value = "/employee",method = RequestMethod.GET )
    public String getAll(Model model){
        Collection<Employee> all = employeeDao.getAll();
        model.addAttribute("emp_list",all);
        return "emp_list";
    }

    //添加功能-1 跳转到添加界面
    @RequestMapping(value = "/to/add",method = RequestMethod.GET)
    public String add(){
        return "emp_add";
    }
    //添加功能-2 提交表单后进行添加 后转到初始界面
    @RequestMapping(value = "/employee", method = RequestMethod.POST)
    public String addEmployee(Employee employee){
        //保存员工信息
        employeeDao.save(employee);
        //保存好了之后转到最初的界面
        return "redirect:/employee";
    }

    //修改功能-1 获取员工信息，并开始跳转
    @RequestMapping(value = "/employee/{id}",method = RequestMethod.GET)
    public String getEmp(@PathVariable("id") Integer id,Model model){
        Employee employee = employeeDao.get(id);
        model.addAttribute("employee",employee);
        return "emp_update";
    }
    //修改功能-2 提交修改信息后进行修改
    @RequestMapping(value = "/employee",method = RequestMethod.PUT)
    public String empUpdate(Employee employee){
        employeeDao.save(employee);
        return "redirect:/employee";
    }

    //删除功能
    @RequestMapping(value = "/employee/{id}",method = RequestMethod.DELETE)
    public String delete(@PathVariable("id") Integer id){
        employeeDao.delete(id);
        return "redirect:/employee";
    }
}
