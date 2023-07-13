package com.mantis.mapper;

import com.mantis.data.dto.UserDTO;
import com.mantis.data.entity.User;

public class UserMapper {
    public UserDTO toDTO(User user){
        UserDTO _user= new UserDTO();
        _user.setLastName(user.getLastName());
        _user.setName(user.getName());
        _user.setId(user.getId());
        _user.setPhone(user.getPhone());
        _user.setEmail(user.getEmail());


        return _user;
    }

    public User toEntity(UserDTO user){
        User _user= new User();
        _user.setLastName(user.getLastName());
        _user.setName(user.getName());
        _user.setId(user.getId());
        _user.setIdentityNumber(user.getIdentityNumber());
        _user.setPhone(user.getPhone());
        _user.setEmail(user.getEmail());
        _user.setPassword(user.getPassword());

        return _user;

    }
}
