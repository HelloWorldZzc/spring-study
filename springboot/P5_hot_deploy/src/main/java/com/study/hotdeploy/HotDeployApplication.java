package com.study.hotdeploy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HotDeployApplication {
    public static void main(String[] args) {
        //虽然在配置也设置了，但是在java环境变量中设置的优先级更高，在此处生效
        System.setProperty("spring.devtools.restart.enabled:","false");
        SpringApplication.run(HotDeployApplication.class, args);
    }
}
