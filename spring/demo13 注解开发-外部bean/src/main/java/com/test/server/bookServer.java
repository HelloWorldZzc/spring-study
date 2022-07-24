package com.test.server;

import org.springframework.stereotype.Component;

@Component
public class bookServer {
    public void save() {
        System.out.println("book service save ...");
    }
}
