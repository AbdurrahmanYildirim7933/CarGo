package com.mantis.data.entity;

import jakarta.persistence.*;
import org.antlr.v4.runtime.misc.NotNull;

@Entity
@Table(name="tbl_repair_service_workers")
public class RepairServiceWorkers {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name="id")
        private Integer id;
        @Column(name="name")
        private String name;
        @Column(name="last_name")
        private String lastName;
        @Column(name="address")
        private String address;
        @Column(name="phone")
        private int phone;
        @Column(name="identity_number")
        private int identityNumber;

        @NotNull
        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "repair_service_id", nullable = false)
        private RepairService repairService;

}
