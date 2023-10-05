package com.study.mail;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import javax.mail.internet.MimeMessage;
import java.io.File;

@SpringBootTest
public class sendMail {
    @Resource
    private JavaMailSender javaMailSender;

    //发送人
    private final String from = "zzc_wx@qq.com";
    //接收人
    private final String to = "zzc121382000@163.com";
    //标题
    private final String subject = "测试邮件_这是邮件的标题";
    //正文
    private String context = "null";

    @Test
    public void test1(){
        //邮件带有超链接、图片等方式等使用HTML元素对其进行渲染的行为，对正文进行修改
        context="<a href='www.baidu.com'>这是一个跳转到百度的超链接</a>";
        try {
            //创建标准邮件发送的方式
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            //第二个参数表示true，表示添加附件的意思
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage,true);
            mimeMessageHelper.setFrom(from+"(testEmail)");
            mimeMessageHelper.setTo(to);
            mimeMessageHelper.setSubject(subject);
            //第二个true表示，使用HTML对其进行渲染，否则不使用HTML对其进行渲染
            mimeMessageHelper.setText(context,true);
            javaMailSender.send(mimeMessage);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Test
    public void test2(){
        //添加附件的方式
        File file = new File("note.txt");
        Assert.isTrue(file.exists(),"文件不存在");

        try {
            //创建标准邮件发送的方式
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            //添加附件
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage,true);
            mimeMessageHelper.setFrom(from+"(testEmail)");
            mimeMessageHelper.setTo(to);
            mimeMessageHelper.setSubject(subject);
            //第二个true表示，使用HTML对其进行渲染，否则不使用HTML对其进行渲染
            mimeMessageHelper.setText(context,true);

            //添加附件
            mimeMessageHelper.addAttachment("笔记.txt",file);
            javaMailSender.send(mimeMessage);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
