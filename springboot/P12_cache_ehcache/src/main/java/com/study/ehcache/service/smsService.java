package com.study.ehcache.service;

import com.study.ehcache.util.codeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class smsService {
    @Autowired
    private codeUtil util;

    //发送 把验证码存入缓存
    @Cacheable( value = "smsCode",key = "#tel")
    public String sendCode(String tel){
        return util.generator(tel);
    }

    //检验验证码是否正确
    public boolean checkCode(String tel,String code){
        return code.equals(util.getCode(tel));
    }

    //清除缓存
    @CacheEvict(value = "smsCode" ,key = "#tel")
    public void delete(String tel){

    }



}
