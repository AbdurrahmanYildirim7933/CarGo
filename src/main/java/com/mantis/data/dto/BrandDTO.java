package com.mantis.data.dto;

import com.mantis.data.entity.Car;
import com.mantis.data.entity.Model;
import jakarta.persistence.*;

import java.util.List;

public class BrandDTO {
    private Integer id;
    private String name;
    private List<CarDTO> cars;
    private List<ModelDTO> models;

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

    public List<CarDTO> getCars() {
        return cars;
    }

    public void setCars(List<CarDTO> cars) {
        this.cars = cars;
    }

    public List<ModelDTO> getModels() {
        return models;
    }

    public void setModels(List<ModelDTO> models) {
        this.models = models;
    }
}
