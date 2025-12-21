package com.example.demo.model;

import java.time.LocalDate;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;

@Entity
@Table(name="risk_rule")
public class RiskRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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

    // Constructors
    public RiskRule() {}

    public RiskRule(Long id, String ruleName, String AFTER_HOURS, String FREQUENT_VISITS, String BLACKLIST,
                    String KEYWORD, String CUSTOM, int threshold, int scoreImpact, LocalDate createdAt) {
        this.id = id;
        this.ruleName = ruleName;
        this.AFTER_HOURS = AFTER_HOURS;
        this.FREQUENT_VISITS = FREQUENT_VISITS;
        this.BLACKLIST = BLACKLIST;
        this.KEYWORD = KEYWORD;
        this.CUSTOM = CUSTOM;
        this.threshold = threshold;
        this.scoreImpact = scoreImpact;
        this.createdAt = createdAt;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getRuleName() { return ruleName; }
    public void setRuleName(String ruleName) { this.ruleName = ruleName; }
    public String getAFTER_HOURS() { return AFTER_HOURS; }
    public void setAFTER_HOURS(String AFTER_HOURS) { this.AFTER_HOURS = AFTER_HOURS; }
    public String getFREQUENT_VISITS() { return FREQUENT_VISITS; }
    public void setFREQUENT_VISITS(String FREQUENT_VISITS) { this.FREQUENT_VISITS = FREQUENT_VISITS; }
    public String getBLACKLIST() { return BLACKLIST; }
    public void setBLACKLIST(String BLACKLIST) { this.BLACKLIST = BLACKLIST; }
    public String getKEYWORD() { return KEYWORD; }
    public void setKEYWORD(String KEYWORD) { this.KEYWORD = KEYWORD; }
    public String getCUSTOM() { return CUSTOM; }
    public void setCUSTOM(String CUSTOM) { this.CUSTOM = CUSTOM; }
    public int getThreshold() { return threshold; }
    public void setThreshold(int threshold) { this.threshold = threshold; }
    public int getScoreImpact() { return scoreImpact; }
    public void setScoreImpact(int scoreImpact) { this.scoreImpact = scoreImpact; }
    public LocalDate getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDate createdAt) { this.createdAt = createdAt; }
}
