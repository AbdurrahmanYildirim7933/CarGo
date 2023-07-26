package com.mantis.data.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="tbl_repair_shop")
public class RepairShop {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name="id")
        private Integer id;
        @Column(name="address")
        private String address;
        @Column(name="name")
        private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "repairShop")
    private List<RepairShopWorkers> repairShopWorkers;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "repairShop")
    private List<RepairShopDutyRelation> repairShopDutyRelations;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "repairShop")
    private List<UserRepairShopRelation> userRepairShopRelations;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public List<RepairShopWorkers> getRepairShopWorkers() {
        return repairShopWorkers;
    }

    public void setRepairShopWorkers(List<RepairShopWorkers> repairShopWorkers) {
        this.repairShopWorkers = repairShopWorkers;
    }

    public List<RepairShopDutyRelation> getRepairShopDutyRelations() {
        return repairShopDutyRelations;
    }

    public void setRepairShopDutyRelations(List<RepairShopDutyRelation> repairShopDutyRelations) {
        this.repairShopDutyRelations = repairShopDutyRelations;
    }

    public List<UserRepairShopRelation> getUserRepairShopRelations() {
        return userRepairShopRelations;
    }

    public void setUserRepairShopRelations(List<UserRepairShopRelation> userRepairShopRelations) {
        this.userRepairShopRelations = userRepairShopRelations;
    }
}
