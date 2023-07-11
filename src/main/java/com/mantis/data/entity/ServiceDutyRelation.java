package com.mantis.data.entity;

import jakarta.persistence.*;

@Entity
@Table(name="tbl_service_duty_relation")
public class ServiceDutyRelation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer duty_id;
    @Column(name="service_id")
    private Integer service_id;
    @Column(name="price")
    private double price;
    @ManyToOne
    @JoinColumn (name="duty_id")
    private Duty duty;

    @ManyToOne
    @JoinColumn (name="service_id")
    private RepairService repairService;

    public Integer getDuty_id() {
        return duty_id;
    }

    public void setDuty_id(Integer duty_id) {
        this.duty_id = duty_id;
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
