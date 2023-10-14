package com.study.client.metrics;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
//性能部分
public class demo {
    private Counter count ;
    //使用required=false是为了防止系统报警告
    public demo(@Autowired(required = false) MeterRegistry meterRegistry){
        //下拉框中存在这个选项
        count=meterRegistry.counter("用户访问次数");
    }

    //模拟请求访问，增加用户访问次数
    @GetMapping("/add")
    public String add(){
        //访问次数增加
        count.increment();
        return "add。。。ok";
    }
}
