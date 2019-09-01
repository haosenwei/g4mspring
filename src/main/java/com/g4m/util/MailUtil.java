package com.g4m.util;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.security.Security;
import java.util.Properties;

/**
 * 发送邮件Util
 */
public class MailUtil {

    //邮箱
    private static String mailServerHost = "smtp.163.com";
    private static String mailSenderAddress = "18141928965@163.com";
    private static String mailSenderNick = "树莓派";
    private static String mailSenderUsername = "18141928965@163.com";
    private static String mailSenderPassword = "murong123";

    /**
     * 发送 邮件方法 (Html格式，支持附件)
     *
     * @return void
     */
    public static void sendEmail(String subject, String msg, String address) {

        try {
            Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
            final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
            final Properties p = System.getProperties();
            p.setProperty("mail.smtp.host", mailServerHost);
            p.setProperty("mail.smtp.auth", "true");
            p.setProperty("mail.smtp.user", mailSenderUsername);
            p.setProperty("mail.smtp.pass", mailSenderPassword);

            p.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY);
            p.setProperty("mail.smtp.socketFactory.fallback", "false");
            //邮箱发送服务器端口,这里设置为465端口
            p.setProperty("mail.smtp.port", "465");
            p.setProperty("mail.smtp.socketFactory.port", "465");

            // 根据邮件会话属性和密码验证器构造一个发送邮件的session
            Session session = Session.getInstance(p, new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(p.getProperty("mail.smtp.user"), p.getProperty("mail.smtp.pass"));
                }
            });
            session.setDebug(true);
            Message email = new MimeMessage(session);
            email.setSubject(subject);

            email.setContent(msg, "text/html;charset=utf-8");

            // 收件人
            InternetAddress fromAddress = new InternetAddress(mailSenderAddress);
            InternetAddress toAddress = new InternetAddress(address);
            email.setRecipient(Message.RecipientType.TO, toAddress);
            email.setFrom(fromAddress);

            email.saveChanges();
            Transport.send(email);
            System.out.println("email-send success！");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
