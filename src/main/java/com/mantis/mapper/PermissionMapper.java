package com.mantis.mapper;

import com.mantis.data.dto.PermissionDTO;
import com.mantis.data.dto.RoleDTO;
import com.mantis.data.entity.Permission;
import com.mantis.data.entity.Role;

public class PermissionMapper {

    public PermissionDTO toDTO(Permission perm){
        PermissionDTO _perm= new PermissionDTO();
        _perm.setId(perm.getId());
        _perm.setName(perm.getName());
        _perm.setDescription(perm.getDescription());
        _perm.setRoles(perm.getRoles());

        return _perm;
    }

    public Permission toEntity(PermissionDTO permDTO){
        Permission _perm= new Permission();
        _perm.setId(permDTO.getId());
        _perm.setName(permDTO.getName());
        _perm.setDescription(permDTO.getDescription());
        _perm.setRoles(permDTO.getRoles());

        return _perm;
    }


}
