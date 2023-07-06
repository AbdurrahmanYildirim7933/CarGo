package com.mantis.logic;

import com.mantis.data.dto.UserDTO;
import com.mantis.data.entity.User;
import com.mantis.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Optional;

@Component
public class UserLogic {
@Autowired
    UserRepository userRepository;

    public User findById(Integer id) {
        if (id == null || id == 0) {
            throw new RuntimeException("ID cannot be null");
        }

        return null;
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public void deleteUser(Integer id) {
        if (id == null || id == 0) {
            throw new RuntimeException("ID cannot be null");
        }

        userRepository.deleteById(id);
    }


}
