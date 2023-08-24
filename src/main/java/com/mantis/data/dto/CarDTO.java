package com.mantis.data.dto;

import com.mantis.data.entity.Brand;
import com.mantis.data.entity.Garage;
import com.mantis.data.entity.Model;
import jakarta.persistence.*;
import org.antlr.v4.runtime.misc.NotNull;

public class CarDTO {
    private Integer id;
    private Integer year;
    private String licensePlate;
    private GarageDTO garage;
    private BrandDTO brand;
    private ModelDTO model;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public GarageDTO getGarage() {
        return garage;
    }

    public void setGarage(GarageDTO garage) {
        this.garage = garage;
    }

    public BrandDTO getBrand() {
        return brand;
    }

    public void setBrand(BrandDTO brand) {
        this.brand = brand;
    }

    public ModelDTO getModel() {
        return model;
    }

    public void setModel(ModelDTO model) {
        this.model = model;
    }
}
