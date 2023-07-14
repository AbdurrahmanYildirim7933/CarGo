package com.mantis.api;

import com.mantis.data.dto.UserDTO;
import com.mantis.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/auth")
public class AuthenticationApi {

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/login")
    public boolean login(@RequestBody UserDTO userDTO)
    {
      return(authenticationService.login(userDTO));
    }


}
