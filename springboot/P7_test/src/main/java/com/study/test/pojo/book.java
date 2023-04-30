package com.study.test.pojo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "testcast.book")
public class book {
    private int id;
    private int id2;
    private int count;
    private String name;


    public book() {
    }

    public book(int id, int id2, int count, String name) {
        this.id = id;
        this.id2 = id2;
        this.count = count;
        this.name = name;
    }

    /**
     * 获取
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * 设置
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * 获取
     * @return id2
     */
    public int getId2() {
        return id2;
    }

    /**
     * 设置
     * @param id2
     */
    public void setId2(int id2) {
        this.id2 = id2;
    }

    /**
     * 获取
     * @return count
     */
    public int getCount() {
        return count;
    }

    /**
     * 设置
     * @param count
     */
    public void setCount(int count) {
        this.count = count;
    }

    /**
     * 获取
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    public String toString() {
        return "book{id = " + id + ", id2 = " + id2 + ", count = " + count + ", name = " + name + "}";
    }
}
