package com.study.task.demo;

import java.util.Timer;
import java.util.TimerTask;

public class demo {
    public static void main(String[] args) {
        //创建定时任务对象
        Timer timer=new Timer();
        //创建定时任务
        TimerTask timerTask = new TimerTask(){
            //重写run方法，本质上是一个多线程
            @Override
            public void run() {
                System.out.println("javaTimer task run....");
            }
        };
        //()
        timer.schedule(timerTask,0,2000);
    }
}
