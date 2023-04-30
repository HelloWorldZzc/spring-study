package com.study.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.ContentResultMatchers;
import org.springframework.test.web.servlet.result.HeaderResultMatchers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.result.StatusResultMatchers;


//开启端口测试
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//开启虚拟mvc调用
@AutoConfigureMockMvc

public class TestApplication3 {


    @Test
    //简单使用
    //注入虚拟mvc的调用对象(一种新的书写方式，原方式也行但会报错，但能运用，IDE的bug)
    public void test1(@Autowired MockMvc mvc) throws Exception {
        //创建虚拟get请求，当前访问的是/位置 （前缀不用写） get表示请求方式
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/");
        //执行请求 mockMVC已经帮我们执行了
        mvc.perform(builder);
    }

    //web测试：状态匹配
    @Test
    public void test2(@Autowired MockMvc mvc) throws Exception {
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/");
        //执行完成之后，收集状态执行的结果
        ResultActions perform = mvc.perform(builder);
        //进行状态匹配，获取状态(根据idea提醒)
        StatusResultMatchers status = MockMvcResultMatchers.status();
        ResultMatcher ok = status.isOk();
        //进行对比，成功则测试通过，失败则显示信息
        perform.andExpect(ok);
    }

    //状态匹配-返回值匹配
    @Test
    public void test3(@Autowired MockMvc mvc) throws Exception {
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/");
        //执行完成之后，收集状态执行的结果
        ResultActions perform = mvc.perform(builder);
        //进行状态匹配，获取状态(根据idea提醒)
        ContentResultMatchers content = MockMvcResultMatchers.content();
        ResultMatcher s = content.string("return返回内容：demo....");
        //进行对比，成功则测试通过，失败则显示信息
        perform.andExpect(s);
    }

    //状态匹配-返回值匹配-json
    @Test
    public void test4(@Autowired MockMvc mvc) throws Exception {
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/user");
        //执行完成之后，收集状态执行的结果
        ResultActions perform = mvc.perform(builder);
        //进行状态匹配，获取状态(根据idea提醒)
        ContentResultMatchers content = MockMvcResultMatchers.content();
        ResultMatcher s = content.json("{\"name\":\"zs\"}");
        //进行对比，成功则测试通过，失败则显示信息
        perform.andExpect(s);
    }

    //响应头匹配
    @Test
    public void test5(@Autowired MockMvc mvc) throws Exception {
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/user");
        //执行完成之后，收集状态执行的结果
        ResultActions perform = mvc.perform(builder);
        //进行状态匹配，获取状态(根据idea提醒)
        HeaderResultMatchers header = MockMvcResultMatchers.header();
        //MockHttpServletResponse中查找相关信息
        ResultMatcher s = header.string("Content-Type", "application/json");
        perform.andExpect(s);
    }




}
