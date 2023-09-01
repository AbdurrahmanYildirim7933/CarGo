package com.mantis.data.dto;

import org.springframework.data.domain.Page;

import java.util.List;

public class QueryModel {

    private List<GarageDTO> garages;

    private long count;

    private long pages;

    private List<CarDTO> cars;

    public List<CarDTO> getCars() {
        return cars;
    }

    public void setCars(List<CarDTO> cars) {
        this.cars = cars;
    }

    public List<GarageDTO> getGarages() {
        return garages;
    }

    public void setGarages(List<GarageDTO> garages) {
        this.garages = garages;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public long getPages() {
        return pages;
    }

    public void setPages(long pages) {
        this.pages = pages;
    }
}
