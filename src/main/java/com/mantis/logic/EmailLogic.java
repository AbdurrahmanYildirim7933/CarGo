package com.mantis.logic;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Component
public class EmailLogic {
    @Value("${spring.url}")
    private String verifyUrl;
    private final JavaMailSender javaMailSender;

    public EmailLogic(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }
    public void sendEmail(String to,String subject,Integer userId) throws MessagingException {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message,true);


        String text = verifyUrl+userId;
        helper.setText(text);
        helper.setTo(to);
        helper.setSubject(subject);
        javaMailSender.send(message);
    }
}
