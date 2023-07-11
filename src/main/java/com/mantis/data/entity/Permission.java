package com.mantis.data.entity;

import jakarta.persistence.*;
import org.antlr.v4.runtime.misc.NotNull;
@Entity
@Table(name="tbl_permission")
public class Permission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;
    @Column(name = "name")
    @NotNull
    private String name;
    @Column(name = "description")
    @NotNull
    private String description;

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

}
