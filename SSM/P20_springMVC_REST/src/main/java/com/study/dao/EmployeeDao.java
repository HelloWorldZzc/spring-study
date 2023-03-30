package com.study.dao;

import com.study.pojo.Employee;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

//数据层 模拟操作，就不用连接数据库了
@Repository
public class EmployeeDao {
    //生成的动态数据
    private static Map<Integer, Employee> employees = null;
    static{
        employees = new HashMap<Integer, Employee>();
        employees.put(1001, new Employee(1001, "E-AA", "aa@163.com", 1));
        employees.put(1002, new Employee(1002, "E-BB", "bb@163.com", 1));
        employees.put(1003, new Employee(1003, "E-CC", "cc@163.com", 0));
        employees.put(1004, new Employee(1004, "E-DD", "dd@163.com", 0));
        employees.put(1005, new Employee(1005, "E-EE", "ee@163.com", 1));
    }
    //从1006开始定义
    private static Integer initId = 1006;
    //增改
    public void save(Employee employee){
        if (employee.getId()==null){
            employee.setId(initId++);
        }
        employees.put(employee.getId(),employee);
    }
    //查
    public Collection<Employee> getAll(){
        return employees.values();
    }
    public Employee get(Integer id){
        return employees.get(id);
    }
    //删
    public void delete(Integer id){
        employees.remove(id);
    }

}
