package com.study.server;

import com.study.dao.userDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class userServer {
    @Autowired
    private userDao userDao;
    public void say(){
        userDao.say();
    }
}
