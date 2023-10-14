package com.study.client.info;

import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
//info
public class demoInfo implements InfoContributor {
    @Override
    public void contribute(Info.Builder builder) {
        //通过builder两个方法 对info进行操作
        //字符串
        builder.withDetail("time",System.currentTimeMillis());
        Map<String,Object> m=new HashMap<>();
        m.put("author","zzc");
        //map集合方式
        builder.withDetails(m);
    }
}
