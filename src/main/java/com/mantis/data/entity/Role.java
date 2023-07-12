package com.mantis.data.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="tbl_role")
public class Role {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        private Integer id;
        @Column(name = "name")
        private String name;
        @Column(name = "description")
        private String description;

        @ManyToMany(fetch = FetchType.LAZY)
        @JoinTable(
                name="tbl_user_role_relation",
                joinColumns = @JoinColumn(name="role_id",referencedColumnName = "id"),
                inverseJoinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"))
        private List<User> users;

        @ManyToMany(fetch = FetchType.LAZY)
        @JoinTable(
                name="tbl_role_permission_relation",
                joinColumns = @JoinColumn(name="role_id",referencedColumnName = "id"),
                inverseJoinColumns = @JoinColumn(name = "permission_id", referencedColumnName = "id"))
        private List<Permission> permissions;


}
