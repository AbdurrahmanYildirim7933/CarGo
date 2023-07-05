package com.mantis.mapper;

import com.mantis.data.dto.UserDTO;
import com.mantis.data.entity.User;

public class UserMapper {
    public UserDTO toDTO(User user){
        UserDTO _user= new UserDTO();
        _user.setLastName(user.getLastName());
        _user.setName(user.getName());
        _user.setId(user.getId());
        return _user;
    }

    public User toEntity(UserDTO user){
        User _user= new User();
        _user.setLastName(user.getLastName());
        _user.setName(user.getName());
        _user.setId(user.getId());
        return _user;
    }
}