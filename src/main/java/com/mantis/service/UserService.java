package com.mantis.service;

import com.mantis.data.dto.UserDTO;
import com.mantis.data.entity.User;
import com.mantis.logic.UserLogic;
import com.mantis.mapper.UserMapper;
import com.mantis.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

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

    @PreAuthorize("hasAuthority('CREATE_USER')")
    public UserDTO createUser(UserDTO userDTO) {
        return  this.userMapper.toDTO(userLogic.createUser(userMapper.toEntity(userDTO))) ;
    }

    @PreAuthorize("hasPermission('CREATE_USER')")
    public void deleteUser(Integer id) {
        userLogic.deleteUser(id);
    }

    public UserDTO updateUser(Integer id, UserDTO userDTO) {
        return userMapper.toDTO(userLogic.updateUser(id, userMapper.toEntity(userDTO)));
    }
}
