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

        public List<RepairServiceDutyRelation> getRepairServiceDutyRelations() {
                return repairServiceDutyRelations;
        }

        public void setRepairServiceDutyRelations(List<RepairServiceDutyRelation> repairServiceDutyRelations) {
                this.repairServiceDutyRelations = repairServiceDutyRelations;
        }
}
