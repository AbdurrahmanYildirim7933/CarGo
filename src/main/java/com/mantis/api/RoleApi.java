package com.mantis.api;

import com.mantis.data.dto.RoleDTO;
import com.mantis.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/role")
public class RoleApi {
    @Autowired
    RoleService roleService;

    @PostMapping("/create-role")
    public ResponseEntity<RoleDTO> createRole(@RequestBody RoleDTO roleDTO) {
       RoleDTO createRoleDTO = roleService.createRole(roleDTO);
        return ResponseEntity.ok(createRoleDTO);
    }

}
