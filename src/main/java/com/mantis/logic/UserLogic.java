package com.mantis.logic;


import com.mantis.data.entity.Role;
import com.mantis.data.entity.User;
import com.mantis.mapper.UserMapper;
import com.mantis.repositories.RoleRepository;
import com.mantis.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@Component
public class UserLogic {
    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;
    @Autowired EmailLogic emailLogic;

    private UserMapper userMapper = new UserMapper();
    private Map<String, User> users = new HashMap<>();
    private final int EXPIRATION_TIME_IN_MINUTES = 5;

    private static final String EMAIL_REGEX = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";


    public static boolean isValidEmail(String email) {
        Pattern pattern = Pattern.compile(EMAIL_REGEX);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public User findById(Integer id) {

        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    public User createUser(User user) throws MessagingException {

        user = checkObjectValidation(user);
        boolean isPaswordValid = checkPasswordValidation(user);
        if (isPaswordValid) {
            System.out.println("Password is valid.");
        } else {
            System.out.println("Password is not valid");
        }



        List<Role> roles = new ArrayList();
        roles.add(roleRepository.findRoleByName("User"));
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(10);
        String hashedPassword = encoder.encode(user.getPassword());
        user.setPassword(hashedPassword);
        user.setRoles(roles);


        User newUser = userRepository.save(user);
        emailLogic.sendEmail(newUser.getEmail(),"E-posta Doğrulama-cargo", newUser.getId());
        return newUser;
    }
    public void setVerifiedById(Integer id){

       User user =  userRepository.findById(id).get();
        Duration duration = Duration.between(user.getCreatedDate(), LocalDateTime.now());
        long minuteDifferent = duration.toMinutes();


        int minuteDifferentInt = (int) minuteDifferent;
        if (minuteDifferentInt>5){
            throw new RuntimeException("Süre Aşımı");
        }
       user.setEmailVerified(true);
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
        existingUser.setPhone(user.getPhone());

        User updatedUser = userRepository.save(existingUser);

        return updatedUser;
    }

    private User checkObjectValidation(User user) {
        String firstName = user.getName();
        if (firstName != null && !firstName.isEmpty()) {
            firstName = firstName.substring(0, 1).toUpperCase() + firstName.substring(1).toLowerCase();
        } else {
            throw new RuntimeException("name must not be null ");
        }
        String lastName = user.getLastName();
        if (lastName != null && !lastName.isEmpty()) {
            lastName = lastName.toUpperCase();
        } else {
            throw new RuntimeException("name must not be null ");
        }
        user.setName(firstName);
        user.setLastName(lastName);


        return user;
    }

    private boolean checkPasswordValidation(User user) {
        String password = user.getPassword();
        String passwordRegex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";

        return password.matches(passwordRegex);

    }



    }







