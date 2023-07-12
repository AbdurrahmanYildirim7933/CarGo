package com.mantis.data.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="tbl_shop")
public class Shop {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name="id")
        private Integer id;
        @Column(name="name")
        private String name;
        @Column(name="address")
        private String address;
        @Column(name="phone")
        private Integer phone;

        @OneToMany(fetch = FetchType.LAZY, mappedBy = "shop")  //SHOP-EMPLOYEE-FK
        private List<Employee> Employees;        //SHOP-EMPLOYEE-FK

        @OneToMany(fetch = FetchType.LAZY, mappedBy = "shop")
        private List<ProductShopRelation> productShopRelations ;

        @ManyToMany(fetch = FetchType.LAZY)
        @JoinTable(
                name="tbl_user_shop_relation",
                joinColumns = @JoinColumn(name="shop_id",referencedColumnName = "id"),
                inverseJoinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"))
        private List<User> users;


}
