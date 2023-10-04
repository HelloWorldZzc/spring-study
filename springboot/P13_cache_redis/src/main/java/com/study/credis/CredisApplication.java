package com.study.credis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class CredisApplication {

    public static void main(String[] args) {
        SpringApplication.run(CredisApplication.class, args);
    }

}
