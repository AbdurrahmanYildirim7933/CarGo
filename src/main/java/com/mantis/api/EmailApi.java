package com.mantis.api;

import com.mantis.data.dto.UserDTO;
import com.mantis.mapper.UserMapper;
import com.mantis.repositories.UserRepository;
import com.mantis.repositories.UserVerificationRepository;
import com.mantis.service.UserService;
import jakarta.persistence.Column;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.UUID;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController
@RequestMapping("api/v1/email")
public class EmailApi {
    @Autowired
    UserService userService;
    @Autowired
    UserVerificationRepository verificationRepository;

    @Autowired
    UserRepository userRepository;

    UserMapper userMapper = new UserMapper();



    @GetMapping("/verify")
    public RedirectView verifyUserByEmail(@RequestParam(name = "userId",required = true) UUID uuid){
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl("http://localhost:4200/verify");
        return redirectView;
    }

    @GetMapping("/verify-code")
    public String verifyUserByCode(@RequestParam String email){
        UserDTO user = new UserDTO();
        user = userMapper.toDTO(userRepository.findUserByEmail(email));
        return verificationRepository.getUserVerificationByUserId(user.getId()).getRandomeCode();
    }


}
