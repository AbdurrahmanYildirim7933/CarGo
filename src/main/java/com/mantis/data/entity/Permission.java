package com.mantis.data.entity;

import com.mantis.common.enums.EPermission;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="tbl_permission")
public class Permission {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        private Integer id;
        @Enumerated(EnumType.STRING)
        @Column(name = "name", unique = true)
        private EPermission name;
        @Column(name = "description")
        private String description;

        @ManyToMany(fetch = FetchType.LAZY)
        @JoinTable(
                name="tbl_role_permission_relation",
                joinColumns = @JoinColumn(name="permission_id",referencedColumnName = "id"),
                        inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
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
