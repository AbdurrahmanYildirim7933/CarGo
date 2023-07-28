package com.mantis.service;

import com.mantis.data.dto.RoleDTO;
import com.mantis.logic.RoleLogic;
import com.mantis.mapper.RoleMapper;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class RoleService {
    @Autowired
    RoleLogic roleLogic;

    RoleMapper roleMapper = new RoleMapper();

    @PreAuthorize("hasAuthority('CREATE_ROLE')")
    public RoleDTO createRole(RoleDTO roleDTO) {
        return  roleMapper.toDTO(roleLogic.createRole(roleMapper.toEntity(roleDTO)));
    }


}
