package com.study.controller;

import com.study.server.userServer;

public class userController {
   private userServer userServer;

    public com.study.server.userServer getUserServer() {
        return userServer;
    }

    public void setUserServer(com.study.server.userServer userServer) {
        this.userServer = userServer;
    }
    public void save(){
        userServer.save();
    }
}
