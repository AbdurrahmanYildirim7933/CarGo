package com.mantis.data.dto;

import jakarta.persistence.Query;
import org.springframework.util.ObjectUtils;

import java.util.HashMap;
import java.util.Map;

public class CarFilterDTO {
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

    private Map<String,Object> params;

    private String getQuery() {
        String query = "";        this.params = new HashMap();

        query += "AND garage_id=:garage";
        params.put("garage",garage.getId());

        if (!ObjectUtils.isEmpty(getYear())) {
            query += " AND c.year=:year";
            params.put("year",+year);
        }
        return query;
    }

    public String getResultQuery(){
        return "SELECT * FROM tbl_car as c WHERE 1=1"+getQuery();
    }
    public String getCountQuery(){
        return "SELECT count(*) FROM tbl_car as c WHERE 1=1"+getQuery();
    }

    public Query getResultQ(Query q){
        if(!ObjectUtils.isEmpty(this.params)){
            params.keySet().forEach(k->{
                q.setParameter(k,params.get(k));
            });
        }


        return q;
    }
}
