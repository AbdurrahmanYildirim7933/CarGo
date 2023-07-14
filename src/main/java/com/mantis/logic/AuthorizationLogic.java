package com.mantis.logic;

import com.mantis.JwtTokenUtil;
import com.mantis.data.entity.User;
import com.mantis.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

@Component
public class AuthorizationLogic {
    @Autowired
    private UserRepository userRepository;


    private JwtTokenUtil jwtTokenUtil = new JwtTokenUtil();

    private BCryptPasswordEncoder matcher = new BCryptPasswordEncoder();

    public String login(User user) {
        if (!ObjectUtils.isEmpty(user.getEmail()) && !ObjectUtils.isEmpty(userRepository.findUserByEmail(user.getEmail()))) {
            String dbPw = userRepository.findUserByEmail(user.getEmail()).getPassword();
            if (matcher.matches(user.getPassword(), dbPw)) {
                String token = generateJwtToken(user.getEmail());
                // Token'i döndür
                return token;
            }else {
                throw new RuntimeException("Hatalı Şifre");
            }
        }
        return null;
    }

    public String generateJwtToken(String email) {
        // JWT tokenını oluşturma işlemleri
        User user = userRepository.findUserByEmail(email);
        String token = jwtTokenUtil.generateToken(user);
        return token;
    }
}
