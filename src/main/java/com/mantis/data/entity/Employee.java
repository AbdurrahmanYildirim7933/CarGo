package com.mantis.data.entity;

import jakarta.persistence.*;
import org.antlr.v4.runtime.misc.NotNull;

@Entity
@Table(name="tbl_employee")
public class Employee {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name="id")
        private Integer id;
        @Column(name="name")
        private String name;
        @Column(name="last_name")
        private String lastName;
        @Column(name="phone")
        private Integer phone;
        @Column(name="address")
        private String address;
        @Column(name="email")
        private String email;

        @NotNull    //SHOP-EMPLOYEE-FK
        @ManyToOne(fetch = FetchType.LAZY)  //SHOP-EMPLOYEE-FK
        @JoinColumn(name = "shop_id", nullable = false)   //SHOP-EMPLOYEE-FK
        private Shop shop;    //SHOP-EMPLOYEE-FK


}
