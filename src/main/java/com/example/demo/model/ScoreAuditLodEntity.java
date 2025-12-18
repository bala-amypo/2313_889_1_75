package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ScoreAuditLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "visitor_id")
    private Visitor visitor;

    @ManyToOne
    @JoinColumn(name = "rule_id")
    private RiskRule appliedRule;

    private Integer scoreChange;
    private String reason;
    private LocalDateTime loggedAt;

    @PrePersist
    protected void onCreate() {
        if (reason == null || reason.isEmpty()) {
            throw new RuntimeException("reason required");
        }
        loggedAt = LocalDateTime.now();
    }
}