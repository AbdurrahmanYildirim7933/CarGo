package com.mantis.logic;


import com.mantis.data.entity.User;
import com.mantis.mapper.UserMapper;
import com.mantis.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


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

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public void deleteUser(Integer id) {
        if (id == null || id == 0) {
            throw new RuntimeException("ID cannot be null");
        }

        userRepository.deleteById(id);
    }

    public User updateUser(Integer id, User user) {
        if (id == null || id == 0) {
            throw new RuntimeException("ID cannot be null");
        }

        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        existingUser.setName(user.getName());
        existingUser.setLastName(user.getLastName());
        existingUser.setIdentityNumber(user.getIdentityNumber());

        User updatedUser = userRepository.save(existingUser);

        return updatedUser;
    }



}
