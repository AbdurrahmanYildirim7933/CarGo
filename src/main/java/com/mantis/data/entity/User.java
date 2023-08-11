package com.mantis.data.entity;

import com.mantis.logic.UserLogic;
import jakarta.persistence.*;
import org.antlr.v4.runtime.misc.NotNull;
import org.hibernate.annotations.Fetch;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.lang.NonNull;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.time.LocalDateTime;
import java.util.*;

@Entity
@Table(name="tbl_user")
public class User {
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
    @Column(name="phone")
    private String phone;

    @Column(name="identity_number", unique = true)
    private String identityNumber;

    @NotNull
    @Column(name="email", unique = true)
    private String email;

    @NotNull
    @Column(name="password")
    private String password;
    @Column(name = "is_email_verified",columnDefinition = "boolean default false")
    private boolean isEmailVerified;
    private String emailVerificationCode;
    private Date verificationCodeExpiryDate;
    private String VerificationToken;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "owner")
    private List<Garage> garages;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private List<UserRepairShopRelation> userRepairShopRelations;
    @Column(name = "created_date")
    @CreatedDate
    private LocalDateTime createdDate;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name="tbl_user_shop_relation",
            joinColumns = @JoinColumn(name="user_id",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "shop_id", referencedColumnName = "id"))
    private List<Shop> shops;

    @ManyToMany
    @JoinTable(
            name="tbl_user_role_relation",
            joinColumns = @JoinColumn(name="user_id",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    private List<Role> roles;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<Garage> getGarages() {
        return garages;
    }

    public void setGarages(List<Garage> garages) {
        this.garages = garages;
    }

    public List<UserRepairShopRelation> getUserRepairShopRelations() {
        return userRepairShopRelations;
    }

    public void setUserRepairShopRelations(List<UserRepairShopRelation> userRepairShopRelations) {
        this.userRepairShopRelations = userRepairShopRelations;
    }

    public List<Shop> getShops() {
        return shops;
    }

    public void setShops(List<Shop> shops) {
        this.shops = shops;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) { this.roles = roles;    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String getIdentityNumber() {
        return identityNumber;
    }

    public void setIdentityNumber(String identityNumber) {
        this.identityNumber = identityNumber;
    }

    public boolean isEmailVerified() {
        return isEmailVerified;
    }

    public void setEmailVerified(boolean emailVerified) {
        isEmailVerified = emailVerified;
    }

    public String getEmailVerificationCode() {
        return emailVerificationCode;
    }

    public void setEmailVerificationCode(String emailVerificationCode) {
        this.emailVerificationCode = emailVerificationCode;
    }

    public Date getVerificationCodeExpiryDate() {
        return verificationCodeExpiryDate;
    }

    public void setVerificationCodeExpiryDate(Date verificationCodeExpiryDate) {
        this.verificationCodeExpiryDate = verificationCodeExpiryDate;
    }
    public void generateVerificationCode() {
        this.emailVerificationCode = UUID.randomUUID().toString();
    }

    public void setVerificationToken(String verificationToken) {
        VerificationToken = verificationToken;
    }



    @PrePersist
    private void beforePersist(){
        this.setCreatedDate(LocalDateTime.now());
    }
}