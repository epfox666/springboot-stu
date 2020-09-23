package com.epfox.springboot09async;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@SpringBootTest
class Springboot09AsyncApplicationTests {

    @Autowired
    JavaMailSenderImpl mailSender;
    @Test
    void contextLoads() {
        //一个简单的邮件
        SimpleMailMessage message = new SimpleMailMessage();
        message.setSubject("你好,epfox~");
        message.setText("再见");
        message.setTo("274625988@qq.com");
        message.setFrom("274625988@qq.com");
        mailSender.send(message);
    }
    @Test
    void contextLoads2() throws MessagingException {
        //一个复杂的邮件
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        //组装！
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,true);
        //正文
        helper.setSubject("你好,epfox~plus");
        helper.setText("<p style='color:red'>再见</p>",true);
        //附件
        helper.addAttachment("1.jpg",new File("C:\\Users\\Administrator\\Desktop\\ok.jpg"));
        helper.addAttachment("2.jpg",new File("C:\\Users\\Administrator\\Desktop\\ok.jpg"));
        helper.setTo("274625988@qq.com");
        helper.setFrom("274625988@qq.com");
        mailSender.send(mimeMessage);
    }

}
