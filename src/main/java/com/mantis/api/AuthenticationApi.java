package com.mantis.api;

import com.mantis.JwtResponse;
import com.mantis.data.dto.SessionDTO;
import com.mantis.data.dto.UserDTO;
import com.mantis.service.AuthenticationService;
import com.mantis.service.UserService;
import io.jsonwebtoken.Jwt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(maxAge = 3600)
@RequestMapping("api/v1/auth")
public class AuthenticationApi {

    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    private UserService userService;

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

    @GetMapping("/me")
    public ResponseEntity<SessionDTO> mySession(){
        return ResponseEntity.ok(authenticationService.getMySession());

    }








}
