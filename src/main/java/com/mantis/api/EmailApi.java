package com.mantis.api;

import com.mantis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("api/v1/email")
public class EmailApi {
    @Autowired
    UserService userService;
    @GetMapping("/verify")
    public ResponseEntity verifyUserByEmail(@RequestParam(name = "uuid",required = true) UUID uuid){
        userService.verifyByUserId(uuid);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
