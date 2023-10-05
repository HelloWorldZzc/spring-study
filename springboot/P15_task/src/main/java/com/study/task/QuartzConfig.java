package com.study.task;

import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//定义工作明细与触发器，并绑定对应关系
@Configuration
public class QuartzConfig {
    @Bean
    public JobDetail printJobDetail(){
        return JobBuilder.newJob(QuartzTaskBean.class).storeDurably().build();
    }

    @Bean
    public Trigger printJobTrigger(){
        //制定计划 五秒执行一次
        ScheduleBuilder<CronTrigger> schedBuilder = CronScheduleBuilder.cronSchedule("0/5 * * * * ?");
        //绑定对应的工作明细
        return TriggerBuilder.newTrigger().forJob(printJobDetail()).withSchedule(schedBuilder).build();
    }
}
