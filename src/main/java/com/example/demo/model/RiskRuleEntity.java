package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RiskRule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(unique = true)
    private String ruleName;
    private String ruleType; // AFTER_HOURS, FREQUENT_VISITS, etc.
    private Integer threshold;
    private Integer scoreImpact;
    private LocalDateTime createdAt;
}