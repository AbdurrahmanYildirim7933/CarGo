package com.mantis.service;

import com.mantis.JwtResponse;
import com.mantis.data.dto.GarageDTO;
import com.mantis.data.dto.SessionDTO;
import com.mantis.data.dto.UserDTO;
import com.mantis.logic.UserLogic;
import com.mantis.mapper.UserMapper;
import com.mantis.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class UserService {
    @Autowired
    private UserLogic userLogic;
    private UserRepository userRepository;
    private UserMapper userMapper= new UserMapper();


    public UserDTO findById(Integer id){
      return  this.userMapper.toDTO(userLogic.findById(id)) ;
    }

    public UserDTO createUser(UserDTO userDTO) throws MessagingException {
        return  this.userMapper.toDTO(userLogic.createUser(userMapper.toEntity(userDTO))) ;
    }

    public UserDTO verifyByUser(UserDTO user){

  return this.userMapper.toDTO(userLogic.setVerifiedById(user.getId(),user.getVerifyCode()));

    }

    @PreAuthorize("hasAuthority('DELETE_USER')")
    public void deleteUser(Integer id) {
        userLogic.deleteUser(id);
    }

    @PreAuthorize("hasAuthority('UPDATE_USER')")
    public UserDTO updateUser(Integer id, UserDTO userDTO) {
        return userMapper.toDTO(userLogic.updateUser(id, userMapper.toEntity(userDTO)));
    }




}
