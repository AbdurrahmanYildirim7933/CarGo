package com.mantis.service;

import com.mantis.data.dto.PermissionDTO;
import com.mantis.logic.PermissionLogic;
import com.mantis.mapper.PermissionMapper;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class PermissionService {
    @Autowired
    PermissionLogic permissionLogic;

    PermissionMapper permissionMapper = new PermissionMapper();

    public PermissionDTO createPermission(PermissionDTO permissionDTO) {
        return  permissionMapper.toDTO(permissionLogic.createPermission(permissionMapper.toEntity(permissionDTO)));
    }




}

