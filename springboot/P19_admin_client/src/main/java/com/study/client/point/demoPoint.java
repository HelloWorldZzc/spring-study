package com.study.client.point;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@Endpoint(id = "demoPon")
public class demoPoint {
    @ReadOperation
    public Object getPay(){
        //调用相关的业务
        Map<String,Integer> m=new HashMap<>();
        m.put("leave 1",1);
        m.put("leave 2",2);
        m.put("leave 3",3);
        return m;
    }
}
