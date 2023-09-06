package com.mantis.data.dto;

import com.mantis.data.entity.Car;
import jakarta.persistence.*;
import org.antlr.v4.runtime.misc.NotNull;

public class CarImageDTO {

    private Integer id;

    private String name;

    private String filebase64;

    private String type;

    private CarDTO car;

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



    public CarDTO getCar() {
        return car;
    }

    public void setCar(CarDTO car) {
        this.car = car;
    }

    public String getFilebase64() {
        return filebase64;
    }

    public void setFilebase64(String filebase64) {
        this.filebase64 = filebase64;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "CarImageDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", filebase64='" + filebase64 + '\'' +
                ", type='" + type + '\'' +
                ", car=" + car +
                '}';
    }
}
