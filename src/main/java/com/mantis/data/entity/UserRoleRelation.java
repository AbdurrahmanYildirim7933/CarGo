package com.mantis.data.entity;

import jakarta.persistence.*;

@Entity
@Table(name="tbl_user_role_relation")
public class UserRoleRelation {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer user_id;
    @Column(name="role_id")
    private Integer role_id;

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getRole_id() {
        return role_id;
    }

    public void setRole_id(Integer role_id) {
        this.role_id = role_id;
    }
}
