package com.example.demo.model;

import java.time.LocalDate;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;

@Entity
@Table(name = "score_logs")
public class ScoreAuditLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Min(0)
    private int scoreChange;

    private String reason;

    private LocalDate loggedAt;

    public ScoreAuditLog() {}

    public ScoreAuditLog(int scoreChange, String reason, LocalDate loggedAt) {
        this.scoreChange = scoreChange;
        this.reason = reason;
        this.loggedAt = loggedAt;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public int getScoreChange() { return scoreChange; }
    public void setScoreChange(int scoreChange) { this.scoreChange = scoreChange; }

    public String getReason() { return reason; }
    public void setReason(String reason) { this.reason = reason; }

    public LocalDate getLoggedAt() { return loggedAt; }
    public void setLoggedAt(LocalDate loggedAt) { this.loggedAt = loggedAt; }
}
