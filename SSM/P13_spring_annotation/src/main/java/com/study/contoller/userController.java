package com.study.contoller;

import com.study.server.userServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class userController {
    @Autowired
    private userServer userServer;
    public void say(){
        userServer.say();
    }
}
