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

        public Integer getId() {
                return id;
        }

        public void setId(Integer id) {
                this.id = id;
        }

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        public String getDescription() {
                return description;
        }

        public void setDescription(String description) {
                this.description = description;
        }

        public List<User> getUsers() {
                return users;
        }

        public void setUsers(List<User> users) {
                this.users = users;
        }

        public List<Permission> getPermissions() {
                return permissions;
        }

        public void setPermissions(List<Permission> permissions) {
                this.permissions = permissions;
        }
}
