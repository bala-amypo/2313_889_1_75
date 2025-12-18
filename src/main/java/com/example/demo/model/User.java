package com.example.demo.model;
import jakarta.persistence.*;

public class User {
    @Id
    private Long id;
    @Column(unique=true)
    private String email;
    private String password;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public User(Long id, String email, String password) {
        this.id = id;
        this.email = email;
        this.password = password;
    }
    public User() {
    }

    

}
