package com.mantis.data.entity;

import jakarta.persistence.*;
import org.antlr.v4.runtime.misc.NotNull;

@Entity
@Table(name="tbl_serviceWorkers")
public class ServiceWorkers {
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
    @Column(name = "identiy_number")
    @NotNull
    private Integer identityNumber;
    @Column(name = "address")
    @NotNull
    private String address;

    @ManyToOne
    @JoinColumn (name="service_id")
    private RepairService repairService;

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

    public Integer getIdentityNumber() {
        return identityNumber;
    }

    public void setIdentityNumber(Integer identityNumber) {
        this.identityNumber = identityNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getServiceId() {
        return serviceId;
    }

    public void setServiceId(Integer serviceId) {
        this.serviceId = serviceId;
    }

    @Column(name = "service_id")
    @NotNull
    private Integer serviceId;

}
