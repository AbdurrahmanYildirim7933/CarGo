package com.mantis.service;

import com.mantis.JwtResponse;
import com.mantis.data.dto.SessionDTO;
import com.mantis.data.dto.UserDTO;
import com.mantis.logic.AuthorizationLogic;
import com.mantis.mapper.UserMapper;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class AuthenticationService {
@Autowired
 private AuthorizationLogic authorizationLogic;
 private UserMapper userMapper = new UserMapper();

    public String login(UserDTO user)
    {
        return (authorizationLogic.login(userMapper.toEntity(user)));
    }

    ;//@PreAuthorize("hasAuthority('GET_SESSION')")
    public SessionDTO getMySession() {
        return authorizationLogic.getSession();
    }


}
