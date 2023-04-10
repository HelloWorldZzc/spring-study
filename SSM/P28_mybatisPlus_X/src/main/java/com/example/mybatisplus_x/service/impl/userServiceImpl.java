package com.example.mybatisplus_x.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.mybatisplus_x.pojo.user;
import com.example.mybatisplus_x.service.userService;
import com.example.mybatisplus_x.mapper.userMapper;
import org.springframework.stereotype.Service;

/**
* @author ASUS
* @description 针对表【user_mybatis_plus】的数据库操作Service实现
* @createDate 2023-03-30 22:41:29
*/
@Service
public class userServiceImpl extends ServiceImpl<userMapper, user>
    implements userService{

}




