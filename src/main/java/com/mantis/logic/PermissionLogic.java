package com.mantis.logic;

import com.mantis.data.entity.Permission;
import com.mantis.repositories.PermissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PermissionLogic {
    @Autowired
    PermissionRepository permissionRepository;

    public Permission createPermission(Permission permission) {

        return permissionRepository.save(permission);
    }

}
