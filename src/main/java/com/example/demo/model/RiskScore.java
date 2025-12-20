package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "risk_scores")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RiskScore {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "visitor_id", nullable = false)
    private Visitor visitor;

    private Integer totalScore;

    private String riskLevel; // LOW, MEDIUM, HIGH, CRITICAL

    private LocalDateTime evaluatedAt;
}