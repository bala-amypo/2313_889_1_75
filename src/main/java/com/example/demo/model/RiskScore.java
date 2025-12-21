package com.example.demo.model;

import java.time.LocalDate;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;

@Entity
@Table(name="risk_score")
public class RiskScore {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Min(0)
    private int totalScore;

    private String LOW;
    private String MEDIUM;
    private String HIGH;
    private String CRITICAL;

    private LocalDate evaluatedAt;

    public RiskScore() {}

    public RiskScore(Long id, int totalScore, String LOW, String MEDIUM, String HIGH, String CRITICAL, LocalDate evaluatedAt) {
        this.id = id;
        this.totalScore = totalScore;
        this.LOW = LOW;
        this.MEDIUM = MEDIUM;
        this.HIGH = HIGH;
        this.CRITICAL = CRITICAL;
        this.evaluatedAt = evaluatedAt;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public int getTotalScore() { return totalScore; }
    public void setTotalScore(int totalScore) { this.totalScore = totalScore; }
    public String getLOW() { return LOW; }
    public void setLOW(String LOW) { this.LOW = LOW; }
    public String getMEDIUM() { return MEDIUM; }
    public void setMEDIUM(String MEDIUM) { this.MEDIUM = MEDIUM; }
    public String getHIGH() { return HIGH; }
    public void setHIGH(String HIGH) { this.HIGH = HIGH; }
    public String getCRITICAL() { return CRITICAL; }
    public void setCRITICAL(String CRITICAL) { this.CRITICAL = CRITICAL; }
    public LocalDate getEvaluatedAt() { return evaluatedAt; }
    public void setEvaluatedAt(LocalDate evaluatedAt) { this.evaluatedAt = evaluatedAt; }
}
