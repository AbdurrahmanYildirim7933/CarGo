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



}
