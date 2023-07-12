package com.mantis.data.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="tbl_product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;
    @Column(name="name")
    private String name;
    @Column(name="description")
    private String description;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
    private List<ProductShopRelation> productShopRelations ;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<ProductShopRelation> getProductShopRelations() {
        return productShopRelations;
    }

    public void setProductShopRelations(List<ProductShopRelation> productShopRelations) {
        this.productShopRelations = productShopRelations;
    }
}
