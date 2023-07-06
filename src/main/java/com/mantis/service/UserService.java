package com.mantis.service;

import com.mantis.data.dto.UserDTO;
import com.mantis.data.entity.User;
import com.mantis.logic.UserLogic;
import com.mantis.mapper.UserMapper;
import com.mantis.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
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

    public UserDTO createUser(User user) {
        return  this.userMapper.toDTO(userLogic.createUser(user)) ;
    }

    public void deleteUser(Integer id) {
        userLogic.deleteUser(id);
    }


}
