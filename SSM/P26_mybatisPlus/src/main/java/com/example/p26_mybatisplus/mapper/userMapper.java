package com.example.p26_mybatisplus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.p26_mybatisplus.pojo.user;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public interface userMapper extends BaseMapper<user> {
    //baseMapper中有很多方法，那么继承了之后就可以直接调用了
    //为什么要加Component 防止自动导入的时候报错(自动装配的方式不同导致的报错)


    //不使用baseMapper中的内容，自定义
    Map<String,Object> selectMapById(Long id);
}
