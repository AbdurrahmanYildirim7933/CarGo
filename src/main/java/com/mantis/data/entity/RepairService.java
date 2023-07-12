package com.mantis.data.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="tbl_repair_service")
public class RepairService {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name="id")
        private Integer id;
        @Column(name="address")
        private String address;
        @Column(name="name")
        private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "repairService")
    private List<RepairServiceWorkers> repairServiceWorkers;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "repairService")
    private List<RepairServiceDutyRelation> repairServiceDutyRelations;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "repairService")
    private List<UserRepairServiceRelation> userRepairServiceRelations;

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

    public List<RepairServiceWorkers> getRepairServiceWorkers() {
        return repairServiceWorkers;
    }

    public void setRepairServiceWorkers(List<RepairServiceWorkers> repairServiceWorkers) {
        this.repairServiceWorkers = repairServiceWorkers;
    }

    public List<RepairServiceDutyRelation> getRepairServiceDutyRelations() {
        return repairServiceDutyRelations;
    }

    public void setRepairServiceDutyRelations(List<RepairServiceDutyRelation> repairServiceDutyRelations) {
        this.repairServiceDutyRelations = repairServiceDutyRelations;
    }

    public List<UserRepairServiceRelation> getUserRepairServiceRelations() {
        return userRepairServiceRelations;
    }

    public void setUserRepairServiceRelations(List<UserRepairServiceRelation> userRepairServiceRelations) {
        this.userRepairServiceRelations = userRepairServiceRelations;
    }
}
