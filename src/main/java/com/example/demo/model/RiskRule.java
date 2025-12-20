package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "risk_rules")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RiskRule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String ruleName;

    private String ruleType; // AFTER_HOURS, FREQUENT_VISITS, BLACKLIST, KEYWORD, CUSTOM

    private Integer threshold;

    private Integer scoreImpact;

    private LocalDateTime createdAt;

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }
}