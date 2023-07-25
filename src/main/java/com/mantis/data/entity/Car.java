package com.mantis.data.entity;

import jakarta.persistence.*;
import org.antlr.v4.runtime.misc.NotNull;

@Entity
@Table(name="tbl_car", uniqueConstraints = @UniqueConstraint(columnNames = { "brand", "year", "model", "license_plate" }))
public class Car {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name="id")
        private Integer id;
        @Column(name="year")
        private Integer year;
        @Column(name="license_plate")
        private String licensePlate;
        @NotNull
        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "garage_id", nullable = false)
        private Garage garage;

        @ManyToOne
        @JoinColumn(name="brand", nullable = false)
        private Brand brand;

        @ManyToOne
        @JoinColumn(name ="model", nullable = false)
        private Model model;

        public Integer getId() {
                return id;
        }

        public void setId(Integer id) {
                this.id = id;
        }

        public Integer getYear() {
                return year;
        }

        public void setYear(Integer year) {
                this.year = year;
        }

        public String getLicensePlate() {
                return licensePlate;
        }

        public void setLicensePlate(String licensePlate) {
                this.licensePlate = licensePlate;
        }

        public Garage getGarage() {
                return garage;
        }

        public void setGarage(Garage garage) {
                this.garage = garage;
        }

        public Model getModel() {
                return model;
        }

        public void setModel(Model model) {
                this.model = model;
        }

        public Brand getBrand() {
                return brand;
        }

        public void setBrand(Brand brand) {
                this.brand = brand;
        }
}
