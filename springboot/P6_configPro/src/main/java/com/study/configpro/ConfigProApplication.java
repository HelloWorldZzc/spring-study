package com.study.configpro;

import com.alibaba.druid.pool.DruidDataSource;
import com.study.configpro.pojo.user;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ConfigProApplication {

   @Bean
   //第三方库本身就存在set方法可以注入
   public DruidDataSource druidDataSource_1(){
       DruidDataSource ds = new DruidDataSource();
       ds.setDriverClassName("demo...className");
       return ds;
   }

   //同时可以使用@ConfigurationProperties 完成注入
    @Bean
    @ConfigurationProperties(prefix ="druid")
    public DruidDataSource druidDataSource_2(){
       return new DruidDataSource();
    }


    public static void main(String[] args) {
        //本质上还是通过spring框架运行，拥有相关的容器
        ApplicationContext run = SpringApplication.run(ConfigProApplication.class, args);
        //获取相关的bean 并进行展示（P1通过自动装配获取，原理相同）
        user bean = run.getBean(user.class);
        System.out.println(bean);

        //获取第三方库DruidDataSource的bean
        DruidDataSource ds = (DruidDataSource)run.getBean("druidDataSource_1");
        System.out.println(ds.getDriverClassName());


        //获取第三方库DruidDataSource使用自动注入的bean
        DruidDataSource ds2 = (DruidDataSource)run.getBean("druidDataSource_2");
        System.out.println(ds2.getDriverClassName());
    }

}
