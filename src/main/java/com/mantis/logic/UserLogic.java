package com.mantis.logic;

import com.mantis.data.dto.UserDTO;
import com.mantis.data.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserLogic {
    public User findById(Integer id){
        if(id==null || id==0){
            throw new RuntimeException("ID Must be not null");
        }
        User user = new User();
        user.setId(id);
        user.setName("mantis");
        user.setLastName("yazılım");
        return user;
    }
}
