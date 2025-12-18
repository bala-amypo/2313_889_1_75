package com.example.demo.model;
import java.time.LocalDate;

import jakarta.persistence.*;
@Model
@Table(name="risk-rule")
public class RiskRule {
    @Id
    private Long id ;
    private String ruleName;
    private String AFTER_HOURS;
    private String FREQUENT_VISITS;
    private String BLACKLIST;
    private String KEYWORD;
    private String CUSTOM;
    @Min(0)
    private int threshold;
    @Min(0)
    private int scoreImpact;
    private LocalDate createdAt;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getRuleName() {
        return ruleName;
    }
    public void setRuleName(String ruleName) {
        this.ruleName = ruleName;
    }
    public String getAFTER_HOURS() {
        return AFTER_HOURS;
    }
    public void setAFTER_HOURS(String aFTER_HOURS) {
        AFTER_HOURS = aFTER_HOURS;
    }
    public String getFREQUENT_VISITS() {
        return FREQUENT_VISITS;
    }
    public void setFREQUENT_VISITS(String fREQUENT_VISITS) {
        FREQUENT_VISITS = fREQUENT_VISITS;
    }
    public String getBLACKLIST() {
        return BLACKLIST;
    }
    public void setBLACKLIST(String bLACKLIST) {
        BLACKLIST = bLACKLIST;
    }
    public String getKEYWORD() {
        return KEYWORD;
    }
    public void setKEYWORD(String kEYWORD) {
        KEYWORD = kEYWORD;
    }
    public String getCUSTOM() {
        return CUSTOM;
    }
    public void setCUSTOM(String cUSTOM) {
        CUSTOM = cUSTOM;
    }
    public int getThreshold() {
        return threshold;
    }
    public void setThreshold(int threshold) {
        this.threshold = threshold;
    }
    public int getScoreImpact() {
        return scoreImpact;
    }
    public void setScoreImpact(int scoreImpact) {
        this.scoreImpact = scoreImpact;
    }
    public LocalDate getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }
    public RiskRule(Long id, String ruleName, String aFTER_HOURS, String fREQUENT_VISITS, String bLACKLIST,
            String kEYWORD, String cUSTOM, int threshold, int scoreImpact, LocalDate createdAt) {
        this.id = id;
        this.ruleName = ruleName;
        AFTER_HOURS = aFTER_HOURS;
        FREQUENT_VISITS = fREQUENT_VISITS;
        BLACKLIST = bLACKLIST;
        KEYWORD = kEYWORD;
        CUSTOM = cUSTOM;
        this.threshold = threshold;
        this.scoreImpact = scoreImpact;
        this.createdAt = createdAt;
    }
    public RiskRule() {
    }
    

}
