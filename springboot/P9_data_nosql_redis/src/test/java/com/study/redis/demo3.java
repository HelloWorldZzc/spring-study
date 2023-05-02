package com.study.redis;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

import javax.annotation.Resource;

//redis其他数据类型示例
@SpringBootTest
public class demo3 {
    @Resource
    private StringRedisTemplate redis;

    //写入相关类型
    @Test
    public void test1(){
        HashOperations<String,String,String> hashOperations = redis.opsForHash();
        hashOperations.put("testKeyH","test_K","test_V");
    }

    //读取相关类型
    @Test
    public void test2(){
        HashOperations<String,String,String> hashOperations = redis.opsForHash();
        Object o = hashOperations.get("testKeyH", "test_K");
        System.out.println(o);
    }
}
