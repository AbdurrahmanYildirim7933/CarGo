package com.mantis.data.entity;

import jakarta.persistence.*;

@Entity
@Table(name="tbl_product_shop_relation")
public class ProductShopRelation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer product_id;
    @Column(name="shop_id")
    private Integer shop_id;
    @Column(name="price")
    private double price;

    @Column(name="name")
    private String name;

    @Column(name="description")
    private String description;
    @Column(name="quantity")
    private Integer quantity;

    @ManyToOne
    @JoinColumn (name="shop_id")
    private Shop shop;

    @ManyToOne
    @JoinColumn (name="product_id")
    private Product product;

    public Integer getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Integer product_id) {
        this.product_id = product_id;
    }

    public Integer getShop_id() {
        return shop_id;
    }

    public void setShop_id(Integer shop_id) {
        this.shop_id = shop_id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
