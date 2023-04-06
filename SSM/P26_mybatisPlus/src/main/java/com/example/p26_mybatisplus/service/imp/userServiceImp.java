package com.example.p26_mybatisplus.service.imp;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.p26_mybatisplus.mapper.userMapper;
import com.example.p26_mybatisplus.pojo.user;
import com.example.p26_mybatisplus.service.userService;
import org.springframework.stereotype.Service;

@Service
public class userServiceImp extends ServiceImpl<userMapper, user> implements userService {
}
