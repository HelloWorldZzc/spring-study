package com.study.pojo;

import java.util.List;
import java.util.Map;

public class clazz {
    String name;
    String cid;
    List<student> student;
    Map<String,teacher> teacherMap;

    public clazz(String name, String cid) {
        this.name = name;
        this.cid = cid;
    }

    public clazz() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public List<com.study.pojo.student> getStudent() {
        return student;
    }

    public void setStudent(List<com.study.pojo.student> student) {
        this.student = student;
    }

    public Map<String, teacher> getTeacherMap() {
        return teacherMap;
    }

    public void setTeacherMap(Map<String, teacher> teacherMap) {
        this.teacherMap = teacherMap;
    }

    @Override
    public String toString() {
        return "clazz{" +
                "name='" + name + '\'' +
                ", cid='" + cid + '\'' +
                ", student=" + student +
                ", teacherMap=" + teacherMap +
                '}';
    }
}
