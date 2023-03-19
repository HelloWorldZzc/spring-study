package com.study.pojo;

import java.util.List;

public class dept {
    private int deptId;
    private String deptName;
    private List<emp> emp;

    public dept(int deptId, String deptName) {
        this.deptId = deptId;
        this.deptName = deptName;
    }

    public dept() {
    }

    public int getDeptId() {
        return deptId;
    }

    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public List<com.study.pojo.emp> getEmp() {
        return emp;
    }

    public void setEmp(List<com.study.pojo.emp> emp) {
        this.emp = emp;
    }

    @Override
    public String toString() {
        return "dept{" +
                "deptId=" + deptId +
                ", deptName='" + deptName + '\'' +
                ", emp=" + emp +
                '}';
    }
}
