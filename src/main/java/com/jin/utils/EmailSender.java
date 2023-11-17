package com.jin.utils;

import java.security.GeneralSecurityException;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import com.sun.mail.util.MailSSLSocketFactory;
import lombok.extern.slf4j.Slf4j;


/**
 * @author 大力pig
 * {@code @date} 2023/11/17
 **/
@Slf4j
public class EmailSender {
    public static void sentEmail() throws GeneralSecurityException{
        // 收件人电子邮箱
//        String to = "JinZhu12341@outlook.com";
        String to = "xx@qq.com";

        // 发件人电子邮箱
        String from = "xx@qq.com";

        // 指定发送邮件的主机为 smtp.qq.com
        String host = "smtp.qq.com";  //QQ 邮件服务器

        // 获取系统属性
        Properties properties = System.getProperties();

        // 设置邮件服务器
        properties.setProperty("mail.smtp.host", host);
        properties.put("mail.smtp.auth", "true");
        MailSSLSocketFactory sf = new MailSSLSocketFactory();
        sf.setTrustAllHosts(true);
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.ssl.socketFactory", sf);
        // 获取默认session对象
        Session session = Session.getDefaultInstance(properties, new Authenticator() {
            public PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, "xx"); //发件人邮件用户名、密码
            }
        });

        try {
            // 创建默认的 MimeMessage 对象
            MimeMessage message = new MimeMessage(session);

            // Set From: 头部头字段
            message.setFrom(new InternetAddress(from));

            // Set To: 头部头字段
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            // Set Subject: 头部头字段
            message.setSubject("test" + System.currentTimeMillis());

            // 设置消息体
            message.setText("哈哈,这是测试邮件" + System.currentTimeMillis());

            // 发送消息
            Transport.send(message);
        } catch (MessagingException e) {
            log.error("error: \n" + e.getMessage());
        }
    }


}
