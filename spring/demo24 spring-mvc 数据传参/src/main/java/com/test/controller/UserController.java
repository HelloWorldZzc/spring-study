package com.test.controller;

import com.test.domain.user;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Controller
public class UserController {
    @RequestMapping("/test1")
    @ResponseBody
    public String test1(String name,int age){
        System.out.println("普通传参"+"name:"+name+"  age:"+age);
        return "{'info':'springmvc--user.test1--->普通传参'}";
    }



    //普通参数：请求参数名与形参名不同时，使用@RequestParam注解关联请求参数名称与形参名称之间的关系
    @RequestMapping("/test2")
    @ResponseBody
    public String test2(@RequestParam("name") String userName,int age){
        System.out.println("普通传参"+"name:"+userName+"  age:"+age);
        return "{'info':'springmvc--user.test2--->普通传参-请求参数与形参不同'}";
    }



    //嵌套or对象进行封装(使用不是很多 tip:传参是address.city)
    //http://localhost:8888/test3?name=zhangsan&age=12&address.city=1&address.province="111"
    @RequestMapping("/test3")
    @ResponseBody
    public String pojoParam(user user){
        System.out.println("pojo参数传递 user ==> "+user);
        return "{'module':'pojo param'}";
    }



   // 数组参数：请求参数名与形参对象属性名相同且请求参数为多个，定义数组类型即可接收参数发送请求和参数
   //http://localhost:8888/test4?likes=1&likes=2&likes=3
    @RequestMapping("/test4")
    @ResponseBody
    public String arrayParam(String[] likes){
        System.out.println("数组参数传递 likes ==> "+ Arrays.toString(likes));
        return "{'module':'array param'}";
    }



    //集合参数：同名请求参数可以使用@RequestParam注解映射到对应名称的集合对象中作为数据
    @RequestMapping("/test5")
    @ResponseBody
    //为什么要加注解?
    //SpringMVC将List看做是一个POJO对象来处理，将其创建一个对象并准备把前端的数据封装到对象中，但是List是一个接口无法创建对象，所以报错
    public String listParam(@RequestParam List<String> likes){
        System.out.println("集合参数传递 likes ==> "+ likes);
        return "{'module':'list param'}";
    }

    //集合参数：json格式
    //1.开启json数据格式的自动转换，在配置类中开启@EnableWebMvc
    //2.使用@RequestBody注解将外部传递的json数组数据映射到形参的集合对象中作为数据
    @RequestMapping("/test6")
    @ResponseBody
    public String listParamForJson(@RequestBody List<String> likes){
        System.out.println("list common(json)参数传递 list ==> "+likes);
        return "{'module':'list common for json param'}";
    }


    //POJO参数：json格式
    //1.开启json数据格式的自动转换，在配置类中开启@EnableWebMvc
    //2.使用@RequestBody注解将外部传递的json数据映射到形参的实体类对象中，要求属性名称一一对应
    @RequestMapping("/test7")
    @ResponseBody
    public String pojoParamForJson(@RequestBody user user){
        System.out.println("pojo(json)参数传递 user ==> "+user);
        return "{'module':'pojo for json param'}";
    }


    //集合参数：json格式--->使用场景,一次传递多个对象进来
    //1.开启json数据格式的自动转换，在配置类中开启@EnableWebMvc
    //2.使用@RequestBody注解将外部传递的json数组数据映射到形参的保存实体类对象的集合对象中，要求属性名称一一对应
    @RequestMapping("/test8")
    @ResponseBody
    public String listPojoParamForJson(@RequestBody List<user> list){
        System.out.println("list pojo(json)参数传递 list ==> "+list);
        return "{'module':'list pojo for json param'}";
    }
    //日期参数
    //使用@DateTimeFormat注解设置日期类型数据格式，默认格式yyyy/MM/dd
    //要是不符合这个默认的格式,需要使用@D..来进行格式设定,因为只能满足对应的格式,否则就会报错
    @RequestMapping("/test9")
    @ResponseBody
    public String dataParam(Date date,
                            @DateTimeFormat(pattern="yyyy-MM-dd") Date date1,
                            @DateTimeFormat(pattern="yyyy/MM/dd HH:mm:ss") Date date2){
        System.out.println("参数传递 date ==> "+date);
        System.out.println("参数传递 date1(yyyy-MM-dd) ==> "+date1);
        System.out.println("参数传递 date2(yyyy/MM/dd HH:mm:ss) ==> "+date2);
        return "{'module':'data param'}";
    }
}

