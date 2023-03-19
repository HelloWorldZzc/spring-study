package com.study.pojo;

public class dept {
    private int deptId;
    private String deptName;

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

    @Override
    public String toString() {
        return "dept{" +
                "deptId=" + deptId +
                ", deptName='" + deptName + '\'' +
                '}';
    }
}
