package com.study.controller;

import com.study.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class TestAjaxController {
    //测试ajax请求
    @RequestMapping(value = "/testAjax",method = RequestMethod.POST)
    public void testAjax(@RequestParam("id") Integer id, HttpServletResponse httpServletResponse)throws IOException {
        System.out.println("接收到的id为："+id);
        httpServletResponse.getWriter().println("get data -> testAjax");
    }
    //使用requestBody来获取data数据
    @RequestMapping(value = "/testParam",method = RequestMethod.POST)
    public void testParam(@RequestBody String body, HttpServletResponse response)throws IOException{
        //这里接收的是string 使用比较麻烦
        System.out.println("接收的参数为："+body);
        response.getWriter().println("get data ---> testParam");
    }
    //使用requestBody来获取data数据，使用map方式----需要满足三个条件(见note.txt)
    @RequestMapping(value = "/getParamByMap",method = RequestMethod.POST)
    public void getParamByMap(@RequestBody Map<String,Object> map, HttpServletResponse response)throws IOException{
        System.out.println("接收的参数为："+map);
        response.getWriter().println("get data ---> getParamByMap");
    }
    //使用requestBody来获取data数据，使用实体类Javabean方式----需要满足三个条件(见note.txt)
    @RequestMapping(value = "/getParamByBean",method = RequestMethod.POST)
    public void getParamByBean(@RequestBody User user, HttpServletResponse response)throws IOException{
        System.out.println("接收的参数为："+user);
        response.getWriter().println("get data ---> getParamByMap");
    }
    //使用responseBody返回数据
    @RequestMapping(value = "/responseTest")
    @ResponseBody
    public String responseTest(){
        return "success! responseTest";
    }

    //使用responseBody返回数据，实体类(map也相同)方式 --->需要满足三个条件(见note.txt)
    @RequestMapping(value = "/getResponseJson",method = RequestMethod.GET)
    @ResponseBody
    public User getResponseJson_get(){
        User u=new User(1001,"admin","132");
        return u;
    }
    //使用responseBody返回数据，list方式 --->需要满足三个条件(见note.txt)
    @RequestMapping(value = "/getResponseJson",method = RequestMethod.POST)
    @ResponseBody
    public List<User> getResponseJson_post(){
        List<User> list=new ArrayList<>();
        list.add(new User(1001,"admin","132"));
        list.add(new User(1002,"admin","132"));
        list.add(new User(1003,"admin","132"));
        return list;
    }

}
