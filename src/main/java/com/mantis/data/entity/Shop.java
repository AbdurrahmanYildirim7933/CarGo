package com.mantis.data.entity;

import jakarta.persistence.*;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "tbl_shop")
public class Shop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;
    @Column(name = "name")
    @NotNull
    private String name;
    @Column(name="address")
    @NotNull
    private String address;
    @ManyToMany(mappedBy = "shops")
    private List<User> users;
    @OneToMany(mappedBy = "shop")
    private List<Employee> employees;

    @OneToMany(mappedBy = "shop")
    private List<ProductShopRelation> productShopRelations;

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Column(name = "phone_number")
    @NotNull
    private Integer phoneNumber;
}
