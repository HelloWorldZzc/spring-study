package com.study.redis;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import javax.annotation.Resource;
//StringRedisTemplate使用
@SpringBootTest
public class demo2 {
    @Resource
    private StringRedisTemplate redis;

    //读取操作
    @Test
    public void test1(){
        ValueOperations<String, String> ops = redis.opsForValue();
        ops.set("name","ls");
    }

    //写入操作
    @Test
    public void test2(){
        ValueOperations<String, String> ops = redis.opsForValue();
        String name = ops.get("name");
        System.out.println(name);
    }

    @Test
    public void test3(){
        HashOperations<String, Object, Object> ops = redis.opsForHash();
        Object o = ops.get("testKeyH", "test_K");
        System.out.println(o);

    }
}
