package com.mantis.logic;

import com.mantis.data.entity.User;
import com.mantis.data.entity.UserVerification;
import com.mantis.repositories.UserVerificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.security.SecureRandom;
import java.time.Duration;
import java.time.LocalDateTime;

@Component
public class EmailLogic {
    @Value("${spring.url}")
    private String verifyUrl;
    @Autowired
    UserVerificationRepository verificationRepository;



    private final JavaMailSender javaMailSender;

    public EmailLogic(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }
    public void sendEmailWithUUID(String to,String subject,String uuid,String code,Integer id) throws MessagingException {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message,true);
        code = verificationRepository.getUserVerificationByUserId(id).getRandomeCode();
        String text = "Merhaba,\n\nUUID Kodunuz: " + uuid +
                "\n\nLütfen e-posta doğrulama için aşağıdaki bağlantıya tıklayın:\n" + verifyUrl +uuid+  "\n\n doğrulama kodunuz: " +code ;

        helper.setText(text);
        helper.setTo(to);
        helper.setSubject(subject);

        javaMailSender.send(message);
    }
    public void getUserVerificationByUserId(Integer id){

        User user =  verificationRepository.getUserVerificationByUserId(id).getUserId();
        Duration duration = Duration.between(user.getCreatedDate(), LocalDateTime.now());
        long minuteDifferent = duration.toMinutes();


        int minuteDifferentInt = (int) minuteDifferent;
        if (minuteDifferentInt>5){
            throw new RuntimeException("Süre Aşımı");
        }
        user.setEmailVerified(true);
    }





}
