package com.mantis.data.dto;

import com.mantis.common.enums.EPermission;
import com.mantis.data.entity.Role;

import java.util.List;

public class PermissionDTO {

    private Integer id;
    private EPermission name;
    private String description;
    private List<Role> roles;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public EPermission getName() {
        return name;
    }

    public void setName(EPermission name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
