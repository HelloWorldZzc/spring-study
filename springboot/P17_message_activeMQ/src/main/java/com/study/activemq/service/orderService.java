package com.study.activemq.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class orderService {
    @Autowired
    messageService ser;

    public void order(String id){
        System.out.println("开始处理.....");
        ser.sendMessage(id);
        System.out.println("处理完成.....");
        System.out.println();
    }
}
