package com.test.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.test.server.bookServer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

//管理第三方的bean  拿数据库举例
//以前都是写到相关的配置文件中,现在要回到以前的方法,写到类中
//要是全部写在springConfig文件中,会显得太大了,后期难以维护
//要是分成其他的小部分,后期直接导出 类似于前端的export 那结构不是更加清楚吗?
public class jdbcConfig {

    //应用相关的数据类型  当然了,在springconfig类中也能加上@PropertySource的方式指定外部文件
    @Value("com.mysql.jdbc.Driver")
    private String driver;
    @Value("jdbc:mysql://localhost:3306/spring_db")
    private String url;
    @Value("root")
    private String userName;
    @Value("password")
    private String password;
    @Bean
    //当bean文件需要相关的类时,会自动的帮我们导入
    public DataSource dataSource(bookServer b){
        System.out.println(b);
        DruidDataSource ds = new DruidDataSource();
        ds.setDriverClassName(driver);
        ds.setUrl(url);
        ds.setUsername(userName);
        ds.setPassword(password);
        return ds;
    }
}
