package com.study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class TestScopeController {

    @RequestMapping("/")
    public String main(){
        return "index";
    }

    @RequestMapping("/testServletAPI")
    //使用传统的方式 servletAPI的方式设置
    public String testServletAPI(HttpServletRequest request) {
        request.setAttribute("testScope", "hello,servletAPI");
        return "success";
    }

    @RequestMapping("/ModelAndView")
    //使用ModelAndView向request域对象共享数据
    public ModelAndView modelAndView(){
        //ModelAndView有Model和view的功能,Model主要用于向请求域共享,view主要用于设置视图，实现页面跳转
        ModelAndView mod = new ModelAndView();
        mod.addObject("testScope","hello,modelAndView");
        //设置视图，完成页面跳转
        mod.setViewName("success");
        return mod;
    }
    @RequestMapping("/model")
    //使用Model向request域对象共享数据
    public String model(Model model){
        model.addAttribute("testScope","hello,modelAndView");
        return "success";
    }

    @RequestMapping("/modelMap")
    //使用ModelMap向request域对象共享数据
    public String map(ModelMap modelMap){
        modelMap.addAttribute("testScope","hello,modelMap");
        return "success";
    }
    @RequestMapping("/map")
    public String map(Map<String,Object> map){
        map.put("testScope","hello,Map");
        return "success";
    }


    @RequestMapping("/testSession")
    public String testSession(HttpSession session){
        session.setAttribute("testSession","hello,session");
        return "success";
    }
    @RequestMapping("/testApplication")
    public String testApplication(HttpSession session){
        ServletContext servletContext = session.getServletContext();
        servletContext.setAttribute("testApplication","hello,application");
        return "success";
    }



}
