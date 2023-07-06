package com.mantis.logic;

import com.mantis.data.dto.UserDTO;
import com.mantis.data.entity.User;
import com.mantis.mapper.UserMapper;
import com.mantis.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Optional;

@Component
public class UserLogic {
@Autowired
    UserRepository userRepository;

    private UserMapper userMapper = new UserMapper();

    public User findById(Integer id) {
        if (id == null || id == 0) {
            throw new RuntimeException("ID cannot be null");
        }

        return null;
    }

    public User createUser(UserDTO userDTO) {
        return userRepository.save(userMapper.toEntity(userDTO));
    }

    public void deleteUser(Integer id) {
        if (id == null || id == 0) {
            throw new RuntimeException("ID cannot be null");
        }

        userRepository.deleteById(id);
    }

    public UserDTO updateUser(Integer id, UserDTO userDTO) {
        if (id == null || id == 0) {
            throw new RuntimeException("ID cannot be null");
        }

        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        existingUser.setName(userDTO.getName());
        existingUser.setLastName(userDTO.getLastName());
        existingUser.setIdentityNumber(userDTO.getIdentityNumber());

        User updatedUser = userRepository.save(existingUser);

        return userMapper.toDTO(updatedUser);
    }




}
