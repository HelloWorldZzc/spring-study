package com.study.jetcache;

import com.alicp.jetcache.anno.config.EnableCreateCacheAnnotation;
import com.alicp.jetcache.anno.config.EnableMethodCache;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication(scanBasePackages = {"com.alicp.jetcache.autoconfigure","com.study.jetcache"})
//@EnableMethodCache(basePackages = "com.study.jetcache")
@EnableMethodCache(basePackages = "com.study.jetcache")
@SpringBootApplication()
@EnableCreateCacheAnnotation
public class JetCacheApplication {

    public static void main(String[] args) {
        SpringApplication.run(JetCacheApplication.class, args);
    }

}
