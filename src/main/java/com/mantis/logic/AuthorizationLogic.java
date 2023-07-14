package com.mantis.logic;

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
    private BCryptPasswordEncoder matcher = new BCryptPasswordEncoder();

    public boolean login(User user) {
        if (!ObjectUtils.isEmpty(user.getEmail()) && !ObjectUtils.isEmpty(userRepository.findPasswordByEmail(user.getEmail()))) {

            String dbPw = userRepository.findPasswordByEmail(user.getEmail());


            if (matcher.matches(user.getPassword(), dbPw))
                return true;

        }
        return false;
    }
}
