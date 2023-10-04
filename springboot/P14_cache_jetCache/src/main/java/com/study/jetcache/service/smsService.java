package com.study.jetcache.service;


import com.alicp.jetcache.Cache;
import com.alicp.jetcache.anno.CacheType;
import com.alicp.jetcache.anno.CreateCache;
import com.study.jetcache.util.codeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class smsService {
    @Autowired
    private codeUtil util;

    //半自动形式声明缓存
    @CreateCache(area = "sms",name = "sms_code",expire = 3600,timeUnit = TimeUnit.SECONDS,cacheType = CacheType.LOCAL)
    private Cache<String,String> jetCache;


    //发送 把验证码存入缓存
    public String sendCode(String tel){
        String code = util.generator(tel);
        jetCache.put(tel,code);
        return code;
    }

    //检验验证码是否正确
    public boolean checkCode(String tel,String code){
        //从缓存中读取
        String s = jetCache.get(tel);
        return code.equals(s);
    }

}
