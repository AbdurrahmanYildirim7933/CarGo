package com.mantis.data.dto;

import com.mantis.data.entity.Car;
import jakarta.persistence.*;
import org.antlr.v4.runtime.misc.NotNull;

public class CarImageDTO {

    private Integer id;

    private String name;

    private String fileContentBase64;

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

    public String getFileContentBase64() {
        return fileContentBase64;
    }

    public void setFileContentBase64(String fileContentBase64) {
        this.fileContentBase64 = fileContentBase64;
    }

    public CarDTO getCar() {
        return car;
    }

    public void setCar(CarDTO car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return "CarImageDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", fileContentBase64='" + fileContentBase64 + '\'' +
                ", car=" + car +
                '}';
    }
}
