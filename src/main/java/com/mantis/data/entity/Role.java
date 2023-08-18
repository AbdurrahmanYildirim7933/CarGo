package com.mantis.data.entity;

import jakarta.persistence.*;
import org.springframework.data.repository.cdi.Eager;

import java.util.List;

@Entity
@Table(name="tbl_role")
public class Role {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        private Integer id;
        @Column(name = "name",unique = true)
        private String name;
        @Column(name = "description")
        private String description;


        @ManyToMany(fetch = FetchType.EAGER)
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


        public List<Permission> getPermissions() {
                return permissions;
        }

        public void setPermissions(List<Permission> permissions) {
                this.permissions = permissions;
        }



}
