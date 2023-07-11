package com.mantis.data.entity;

import jakarta.persistence.*;

@Entity
@Table(name="tbl_user_shop_relation")
public class UserShopRelation {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer user_id;
    @Column(name="shop_id")
    private Integer shop_id;

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getShop_id() {
        return shop_id;
    }

    public void setShop_id(Integer shop_id) {
        this.shop_id = shop_id;
    }
}
