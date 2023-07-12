package com.mantis.data.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="tbl_duty")
public class Duty {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name="id")
        private Integer id;
        @Column(name="name")
        private String name;

        @OneToMany(fetch = FetchType.LAZY, mappedBy = "duty")
        private List<RepairServiceDutyRelation> repairServiceDutyRelations;

}
