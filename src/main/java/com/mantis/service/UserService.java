package com.mantis.service;

import com.mantis.data.dto.UserDTO;
import com.mantis.logic.UserLogic;
import com.mantis.mapper.UserMapper;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UserService {
    @Autowired
    UserLogic userLogic;
    private UserMapper userMapper= new UserMapper();
    public UserDTO findById(Integer id){
      return  this.userMapper.toDTO(userLogic.findById(id)) ;
    }
}
