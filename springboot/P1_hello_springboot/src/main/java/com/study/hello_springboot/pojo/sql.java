package com.study.hello_springboot.pojo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "datasource")
public class sql {
    private String driverClassName;
    private String url;
    private String username;
    private String password;


    public sql() {
    }

    public sql(String driverClassName, String url, String username, String password) {
        this.driverClassName = driverClassName;
        this.url = url;
        this.username = username;
        this.password = password;
    }

    /**
     * 获取
     * @return driverClassName
     */
    public String getDriverClassName() {
        return driverClassName;
    }

    /**
     * 设置
     * @param driverClassName
     */
    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }

    /**
     * 获取
     * @return url
     */
    public String getUrl() {
        return url;
    }

    /**
     * 设置
     * @param url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * 获取
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 获取
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    public String toString() {
        return "sql{driverClassName = " + driverClassName + ", url = " + url + ", username = " + username + ", password = " + password + "}";
    }
}
