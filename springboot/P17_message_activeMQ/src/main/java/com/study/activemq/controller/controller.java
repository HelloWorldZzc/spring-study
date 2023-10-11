package com.study.activemq.controller;

import com.study.activemq.service.messageService;
import com.study.activemq.service.orderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class controller {
    @Autowired
    private orderService order;
    @Autowired
    private messageService message;

    @PostMapping("/{id}")
    public void order(@PathVariable("id") String id){
        order.order(id);
    }

    @GetMapping
    public String doMessage(){
        return message.doMessage();
    }
}
