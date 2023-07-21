package com.mantis.logic;

import com.mantis.data.entity.Role;
import com.mantis.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RoleLogic {
    @Autowired
    RoleRepository roleRepository;

    public Role createRole(Role role) {

        return roleRepository.save(role);
    }



}
