package com.study.pojo;

import java.io.Serializable;

//数据与数据库中的数据保持一致，以至于使用resultType就能完成查询操作
public class emp implements Serializable {
    private int emp_id;
    private String emp_name;
    private int age;
    private int dept_id;

    public emp(int emp_id, String emp_name, int age, int dept_id) {
        this.emp_id = emp_id;
        this.emp_name = emp_name;
        this.age = age;
        this.dept_id = dept_id;
    }
    //为了方便测试写出来的特殊函数
    public emp(int age) {
        this.age = age;
    }

    public emp() {
    }

    public int getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(int emp_id) {
        this.emp_id = emp_id;
    }

    public String getEmp_name() {
        return emp_name;
    }

    public void setEmp_name(String emp_name) {
        this.emp_name = emp_name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getDept_id() {
        return dept_id;
    }

    public void setDept_id(int dept_id) {
        this.dept_id = dept_id;
    }

    @Override
    public String toString() {
        return "emp{" +
                "emp_id=" + emp_id +
                ", emp_name='" + emp_name + '\'' +
                ", age=" + age +
                ", dept_id=" + dept_id +
                '}';
    }
}
