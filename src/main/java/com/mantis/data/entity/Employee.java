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
    @Column (name="name")
    @NotNull
    private String name;
    @Column(name="last_name")
    @NotNull
    private String lastName;
    @Column(name="phone_number")
    @NotNull
    private Integer phoneNumber;
    @Column(name = "shop_id")
    @NotNull
    private Integer shopId;
    @Column(name = "address")
    @NotNull
    private String address;
    @Column(name = "e_mail")
    @NotNull
    private String email;

    @ManyToOne
    @JoinColumn(name="shop_id")
    private Shop shop;

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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String geteMail() {
        return email;
    }

    public void seteMail(String eMail) {
        this.email = eMail;
    }



}
