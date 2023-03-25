package com.study.pojo;

import java.util.Arrays;

public class student {
    private Integer sid;
    private String sname;
    private Integer age;
    private Double score;
    private String[] hobby;
    private clazz clazz;

    public clazz getClazz() {
        return clazz;
    }

    public void setClazz(clazz clazz) {
        this.clazz = clazz;
    }

    public student(){}

    public student(Integer sid, String sname, Integer age) {
        this.sid = sid;
        this.sname = sname;
        this.age = age;
    }

    public student(Integer sid, String sname, Double score) {
        this.sid = sid;
        this.sname = sname;
        this.score = score;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public String[] getHobby() {
        return hobby;
    }

    public void setHobby(String[] hobby) {
        this.hobby = hobby;
    }

    @Override
    public String toString() {
        return "student{" +
                "sid=" + sid +
                ", sname='" + sname + '\'' +
                ", age=" + age +
                ", score=" + score +
                ", hobby=" + Arrays.toString(hobby) +
                ", clazz=" + clazz +
                '}';
    }
}
