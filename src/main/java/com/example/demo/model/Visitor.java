package com.example.demo.model;

import java.time.LocalDateTime;

import jakarta.persistence.*;

public class Visitor {
@Id
    private Long id;
    private String fullname;
    @column(unique=true)
    private String email; 
    private String phone;
    private String idproof;
    private LocalDateTime createdAt;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getFullname() {
        return fullname;
    }
    public void setFullname(String fullname) {
        this.fullname = fullname;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getIdproof() {
        return idproof;
    }
    public void setIdproof(String idproof) {
        this.idproof = idproof;
    }
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
    public Visitor() {
    }
    public Visitor(Long id, String fullname, String email, String phone, String idproof,
            LocalDateTime createdAt) {
        this.id = id;
        this.fullname = fullname;
        this.email = email;
        this.phone = phone;
        this.idproof = idproof;
        this.createdAt = createdAt;
    }
 

}