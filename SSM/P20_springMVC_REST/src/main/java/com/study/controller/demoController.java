package com.study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 查询所有的用户信息-->/user-->get
 * 根据id查询用户信息-->/user/1-->get
 * 添加用户信息-->/user-->post
 * 修改用户信息-->/user-->put
 * 删除用户信息-->/user/1-->delete
 */

@Controller
public class demoController {
    //练习使用基本的rest风格完成模拟用户增删改查的操作

    @RequestMapping(value = "/user",method = RequestMethod.GET)
    public String getAll(){
        System.out.println("----查询所有用户信息的操作---");
        return "success";
    }

    @RequestMapping(value = "/user/{id}",method = RequestMethod.GET)
    public String getById(@PathVariable("id") Integer id){
        System.out.println("------查询指定用户id："+id+" 的信息 -----");
        return "success";
    }


    @RequestMapping(value = "/user",method = RequestMethod.POST)
    public String addUser(){
        System.out.println("------添加用户信息------");
        return "success";
    }

    @RequestMapping(value = "/user",method = RequestMethod.PUT)
    public String updateUser(){
        System.out.println("-------修改用户信息--------");
        return "success";
    }

    @RequestMapping(value = "/user/{id}",method = RequestMethod.DELETE)
    public String userDelete(@PathVariable("id") Integer id){
        System.out.println("删除用户id为： "+id+" 的信息 ");
        return "success";
    }
}
