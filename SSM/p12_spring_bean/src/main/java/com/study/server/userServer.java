package com.study.server;

import com.study.dao.userDao;

public class userServer {
    private userDao userDao;


    public void setUserDao(com.study.dao.userDao userDao) {
        this.userDao = userDao;
    }
    public void save(){
        userDao.save();
    }
}
