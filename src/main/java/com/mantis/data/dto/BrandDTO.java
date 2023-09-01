package com.mantis.data.dto;

import com.mantis.data.entity.Car;
import com.mantis.data.entity.Model;
import jakarta.persistence.*;

import java.util.List;

public class BrandDTO {
    private Integer id;
    private String name;

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

}
