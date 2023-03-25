package com.study.pojo;

public class teacher {
    Integer tid;
    String subject;

    public teacher() {
    }

    public teacher(Integer tid, String subject) {
        this.tid = tid;
        this.subject = subject;
    }

    /**
     * 获取
     * @return tid
     */
    public Integer getTid() {
        return tid;
    }

    /**
     * 设置
     * @param tid
     */
    public void setTid(Integer tid) {
        this.tid = tid;
    }

    /**
     * 获取
     * @return subject
     */
    public String getSubject() {
        return subject;
    }

    /**
     * 设置
     * @param subject
     */
    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String toString() {
        return "teacher{tid = " + tid + ", subject = " + subject + "}";
    }
}
