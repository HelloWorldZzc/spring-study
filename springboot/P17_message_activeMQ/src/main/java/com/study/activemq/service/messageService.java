package com.study.activemq.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class messageService {
    @Resource
    private JmsMessagingTemplate messagingTemplate;

    public void sendMessage(String id) {
        System.out.println("待发送短信的订单已纳入处理队列，id："+id);
        //把信息放入消息队列中
        //参数1：消息队列中的位置 参数2：传入的数据
        messagingTemplate.convertAndSend("order.queue.id",id);
    }

    public String doMessage() {
        //从消息队列中获取消息
        //参数1:从XX位置获取，参数2：获取的类型
        String id = messagingTemplate.receiveAndConvert("order.queue.id",String.class);
        System.out.println("已完成短信发送业务，id："+id);
        return id;
    }


}
