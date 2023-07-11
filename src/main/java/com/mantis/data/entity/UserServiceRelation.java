package com.mantis.data.entity;

import jakarta.persistence.*;

@Entity
@Table(name="tbl_user_service_relation")
public class UserServiceRelation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer user_id;
    @Column(name="service_id")
    private Integer service_id;
    @Column(name="price")
    private double price;

    @ManyToOne
    @JoinColumn (name="user_id")
    private User user;

    @ManyToOne
    @JoinColumn (name="service_id")
    private RepairService repairService;

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getService_id() {
        return service_id;
    }

    public void setService_id(Integer service_id) {
        this.service_id = service_id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
