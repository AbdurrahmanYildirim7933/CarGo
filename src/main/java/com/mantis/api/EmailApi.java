package com.mantis.api;

import com.mantis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/email")
public class EmailApi {
    @Autowired
    UserService userService;
    @PostMapping("/verify")
    public ResponseEntity verifyUserByEmail(@RequestParam(name = "userId") Integer id){
        userService.setVerifiedById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
