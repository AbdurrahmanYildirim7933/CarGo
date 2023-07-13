package com.mantis.logic;

import com.mantis.Common;
import com.mantis.data.dto.UserDTO;
import com.mantis.data.entity.User;
import com.mantis.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestBody;

@Component
public class AuthorizationLogic {
    @Autowired
    private UserRepository userRepository;

    public boolean login(User user) {
        if (!ObjectUtils.isEmpty(user.getEmail()) && !ObjectUtils.isEmpty(userRepository.findPasswordByEmail(user.getEmail()))) {
            String hashedPw = Common.hashPw(user.getPassword());

          String dbPw = userRepository.findPasswordByEmail(user.getEmail());

          if(hashedPw.equals(dbPw))
          {
            return true;
          }
              return false;
          //$2a$10$rAdiKHVbQKZ/SdZ.mW/J3eCHSsMKkRoBUeWWCNA1x5iovbnVBhUfC

        }
        return false;
    }


}
