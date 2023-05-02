package com.study.redis;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import javax.annotation.Resource;
//redisTemplate
@SpringBootTest
public class demo1 {
    //自动装配的意思
    @Resource
    //存在两种：redisTemplate，stringRedisTemplate解决报错问题
    @Qualifier("redisTemplate")
    private RedisTemplate redis;

    @Test
    //使用RedisTemplate进行写操作
    public void test1(){
        ValueOperations ops = redis.opsForValue();
        ops.set("name","zs");
    }

    @Test
    //使用RedisTemplate读行写操作
    public void test2(){
        ValueOperations ops = redis.opsForValue();
        String name = (String) ops.get("name");
        System.out.println(name);
    }

}
