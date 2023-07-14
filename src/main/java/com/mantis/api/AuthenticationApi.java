package com.mantis.api;

import com.mantis.JwtResponse;
import com.mantis.data.dto.UserDTO;
import com.mantis.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/auth")
public class AuthenticationApi {

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/login")
    public ResponseEntity<JwtResponse> login(@RequestBody UserDTO userDTO)
    {
        String token = authenticationService.login(userDTO);
        if (!ObjectUtils.isEmpty(token)) {

            JwtResponse jwtResponse = new JwtResponse(token);
            return ResponseEntity.ok(jwtResponse);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }


}
