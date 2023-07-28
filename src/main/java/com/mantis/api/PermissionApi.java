package com.mantis.api;

import com.mantis.data.dto.PermissionDTO;
import com.mantis.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/permission")
public class PermissionApi {

    @Autowired
    PermissionService permissionService;

    @PostMapping("/create-permission")
    public ResponseEntity<PermissionDTO> createPermission(@RequestBody PermissionDTO permissionDTO)
    {
        PermissionDTO createdPermissionDTO = permissionService.createPermission(permissionDTO);
        return ResponseEntity.ok(createdPermissionDTO);
    }




}
