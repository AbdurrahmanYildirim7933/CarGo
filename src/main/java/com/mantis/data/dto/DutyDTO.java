
package com.mantis.data.dto;

import com.mantis.data.entity.RepairShopDutyRelation;

import java.util.List;

public class DutyDTO {
    private Integer id;
    private String name;
    private List<RepairShopDutyRelation> repairShopDutyRelations;

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

    public List<RepairShopDutyRelation> getRepairShopDutyRelation() {
        return repairShopDutyRelations;
    }

    public void setRepairShopDutyRelation(List<RepairShopDutyRelation> repairShopDutyRelations) {
        this.repairShopDutyRelations = repairShopDutyRelations;
    }
}