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

        public Integer getPhone() {
                return phone;
        }

        public void setPhone(Integer phone) {
                this.phone = phone;
        }

        public List<Employee> getEmployees() {
                return Employees;
        }

        public void setEmployees(List<Employee> employees) {
                Employees = employees;
        }

        public List<ProductShopRelation> getProductShopRelations() {
                return productShopRelations;
        }

        public void setProductShopRelations(List<ProductShopRelation> productShopRelations) {
                this.productShopRelations = productShopRelations;
        }

        public List<User> getUsers() {
                return users;
        }

        public void setUsers(List<User> users) {
                this.users = users;
        }
}
