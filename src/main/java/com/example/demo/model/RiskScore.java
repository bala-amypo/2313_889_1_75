package com.example.demo.model;
import java.time.LocalDate;

import jakarta.persistence.*;
@Model
@Table(name="risk-scores")
public class RiskScore {
    @Id
     private Long id;

     @Min(0)
     private int totalScore;
    private String LOW;
    private String MEDIUM;
    private String HIGH;
    private String CRITICAL;
    private LocalDate evaluatedAt;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public int getTotalScore() {
        return totalScore;
    }
    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }
    public String getLOW() {
        return LOW;
    }
    public void setLOW(String lOW) {
        LOW = lOW;
    }
    public String getMEDIUM() {
        return MEDIUM;
    }
    public void setMEDIUM(String mEDIUM) {
        MEDIUM = mEDIUM;
    }
    public String getHIGH() {
        return HIGH;
    }
    public void setHIGH(String hIGH) {
        HIGH = hIGH;
    }
    public String getCRITICAL() {
        return CRITICAL;
    }
    public void setCRITICAL(String cRITICAL) {
        CRITICAL = cRITICAL;
    }
    public LocalDate getEvaluatedAt() {
        return evaluatedAt;
    }
    public void setEvaluatedAt(LocalDate evaluatedAt) {
        this.evaluatedAt = evaluatedAt;
    }
    public RiskScore(Long id, int totalScore, String lOW, String mEDIUM, String hIGH, String cRITICAL,
            LocalDate evaluatedAt) {
        this.id = id;
        this.totalScore = totalScore;
        LOW = lOW;
        MEDIUM = mEDIUM;
        HIGH = hIGH;
        CRITICAL = cRITICAL;
        this.evaluatedAt = evaluatedAt;
    }
    public RiskScore() {
    }
    
    
}
