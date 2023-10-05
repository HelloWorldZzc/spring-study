package com.study.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduleBean {
    @Scheduled(cron = "0/5 * * * * ?")
    public void printLog(){
        System.out.println(Thread.currentThread().getName()+"run。。。。。");
    }
}
