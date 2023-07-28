package com.mantis.data.entity;

import jakarta.persistence.*;
import org.antlr.v4.runtime.misc.NotNull;

@Entity
@Table(name="tbl_repair_shop_workers", uniqueConstraints = @UniqueConstraint(columnNames = {"id","repair_shop_id"}))
public class RepairShopWorkers {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name="id")
        private Integer id;
        @Column(name="name")
        private String name;
        @Column(name="last_name")
        private String lastName;
        @Column(name="address")
        private String address;
        @Column(name="phone")
        private int phone;
        @Column(name="identity_number")
        private int identityNumber;

        @NotNull
        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "repair_shop_id", nullable = false)
        private RepairShop repairShop;

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

        public String getAddress() {
                return address;
        }

        public void setAddress(String address) {
                this.address = address;
        }

        public int getPhone() {
                return phone;
        }

        public void setPhone(int phone) {
                this.phone = phone;
        }

        public int getIdentityNumber() {
                return identityNumber;
        }

        public void setIdentityNumber(int identityNumber) {
                this.identityNumber = identityNumber;
        }

        public RepairShop getRepairShop() {
                return repairShop;
        }

        public void setRepairShop(RepairShop repairShop) {
                this.repairShop = repairShop;
        }
}
