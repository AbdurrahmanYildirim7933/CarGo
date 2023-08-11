package com.mantis.data.dto;

import com.mantis.data.entity.Garage;
import com.mantis.data.entity.Permission;
import com.mantis.data.entity.Role;

import java.util.List;

public class SessionDTO {

    private int id;
    private String name;
    private String lastName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
