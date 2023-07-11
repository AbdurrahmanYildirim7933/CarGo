package com.mantis.data.entity;

import jakarta.persistence.*;

@Entity
@Table(name="tbl_role_permission_relation")
public class RolePermissionRelation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer role_id;
    @Column(name="permission_id")
    private Integer permission_id;

    public Integer getRole_id() {
        return role_id;
    }

    public void setRole_id(Integer role_id) {
        this.role_id = role_id;
    }

    public Integer getPermission_id() {
        return permission_id;
    }

    public void setPermission_id(Integer permission_id) {
        this.permission_id = permission_id;
    }
}
