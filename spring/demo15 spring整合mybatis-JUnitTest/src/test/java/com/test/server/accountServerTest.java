package com.test.server;

/**
 * 这是在完成整合mybatis的基础下,使用JunitTest方法对其进行测试类的处理
 * 需要写明runwith---->用什么启动 configuration---->使用什么配置
 * 这两个都是固定写法咯,面向记忆编程
 * 下面的标注都是很好理解的
 */

import com.test.config.springConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = springConfig.class)
public class accountServerTest {
    @Autowired
    private accountServer accountServer;

    @Test
    public void testFindAll(){
        System.out.println(accountServer.findAll());
    }

}
