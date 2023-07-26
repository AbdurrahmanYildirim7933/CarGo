
package com.mantis.data.dto;

import com.mantis.data.entity.RepairShopDutyRelation;

import java.util.List;

public class RepairShopDTO {

    private int id;
    private String address;
    private String name;
    private List<RepairShopDutyRelation> repairShopDutyRelations;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<RepairShopDutyRelation> getRepairShopDutyRelations() {
        return repairShopDutyRelations;
    }

    public void setRepairShopDutyRelations(List<RepairShopDutyRelation> repairShopDutyRelations) {
        this.repairShopDutyRelations = repairShopDutyRelations;
    }
}