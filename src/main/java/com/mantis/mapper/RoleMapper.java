package com.mantis.mapper;

import com.mantis.data.dto.RoleDTO;
import com.mantis.data.entity.Role;

public class RoleMapper {

    public RoleDTO toDTO(Role role){
        RoleDTO _role= new RoleDTO();
        _role.setId(role.getId());
        _role.setName(role.getName());
        _role.setDescription(role.getDescription());


        return _role;
    }

    public Role toEntity(RoleDTO roleDTO){
        Role _role= new Role();
        _role.setId(roleDTO.getId());
        _role.setName(roleDTO.getName());
        _role.setDescription(roleDTO.getDescription());

        return _role;
    }

}
