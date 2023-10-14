package com.study.client.health;

import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.Status;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
//类名会同步的展示与healthy中
public class healthConfig extends AbstractHealthIndicator {
    @Override
    protected void doHealthCheck(Health.Builder builder) throws Exception {
        //随机展示相关信息
        if (Math.random()>0.01) {
            builder.withDetail("runTime",System.currentTimeMillis());
            Map<String,Integer> info=new HashMap<>();
            info.put("year",2023);
            builder.withDetails(info);
            //表明现在是属于上线状态
            builder.status(Status.UP);
        }else {
            builder.withDetail("运气不好","上线失败");
            builder.status(Status.DOWN);
        }
    }
}
