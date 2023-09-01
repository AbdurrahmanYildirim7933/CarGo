package com.mantis.data.dto;

import com.mantis.data.entity.Car;
import com.mantis.logic.AuthorizationLogic;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GarageFilterDTO {


    private Integer id;

    private String name;

    private UserDTO owner;

    private List<Car> cars;

    private Map<String,Object> params;

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

    public UserDTO getOwner() {
        return owner;
    }

    public void setOwner(UserDTO owner) {
        this.owner = owner;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }


    private String getQuery() {
        String query = "";        this.params = new HashMap();

        query += "AND user_id=:userId";
        params.put("userId",owner.getId());

        if (!ObjectUtils.isEmpty(getName())) {
            query += " AND g.name ILIKE :name";
            params.put("name","%"+name+"%");
        }
        if (!ObjectUtils.isEmpty(getId()) && !getId().equals(null) && !getId().equals(0)) {
            query += " AND g.id=:id";
            params.put("id",+id);
        }
        return query;
    }

    public String getResultQuery(){
        return "SELECT * FROM tbl_garage as g WHERE 1=1"+getQuery();
    }
    public String getCountQuery(){
        return "SELECT count(*) FROM tbl_garage as g WHERE 1=1"+getQuery();
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

