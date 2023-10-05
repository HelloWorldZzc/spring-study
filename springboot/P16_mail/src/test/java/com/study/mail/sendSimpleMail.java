package com.study.mail;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import javax.annotation.Resource;

@SpringBootTest
public class sendSimpleMail {

    @Resource
    private JavaMailSender javaMailSender;

    //发送人
    private final String from = "zzc_wx@qq.com";
    //接收人
    private final String to = "zzc121382000@163.com";
    //标题
    private final String subject = "测试邮件_这是邮件的标题";
    //正文
    private final String context = "测试邮件_这是邮件的内容";

    @Test
    public void sendMail() {
        //创建简单发送邮件对象
        SimpleMailMessage message = new SimpleMailMessage();
        //从哪里发过来的 发件人邮箱 （后面加括号表示收件人收到，所展示的发件人姓名）
        message.setFrom(from+"(springboot_testEmail)");
        message.setTo(to);
        message.setSubject(subject);
        message.setText(context);
        javaMailSender.send(message);
    }
}
