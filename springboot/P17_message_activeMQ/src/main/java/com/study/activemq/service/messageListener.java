package com.study.activemq.service;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

@Component
public class messageListener {
    //普通监听器的功能
//    @JmsListener(destination = "order.queue.id")
//    public void receive(String id){
//        System.out.println("完成发送短信的业务...id："+id);
//
//    }

    //使用监听器调用完消息以后，消息还要被其他地方使用(放入消息队列)
    @JmsListener(destination = "order.queue.id")
    @SendTo("order.other.queue.id")
    public String receive(String id){
        System.out.println("完成发送短信的业务...id："+id);
        return "新消息..."+id;
    }
}
