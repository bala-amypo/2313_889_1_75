package com.example.demo.model;
import java.time.LocalDate;

import jakarta.persistence.*;
import jakarta.xml.bind.annotation.XmlID;
@Model
@Table(name="Score")
public class ScoreAuditLog {
    @Id
    private Long private;
    @Min(0)
    private int scoreChange;
    private String reason;
    private LocalDate loggedAt;
    public int getScoreChange() {
        return scoreChange;
    }
    public void setScoreChange(int scoreChange) {
        this.scoreChange = scoreChange;
    }
    public String getReason() {
        return reason;
    }
    public void setReason(String reason) {
        this.reason = reason;
    }
    public LocalDate getLoggedAt() {
        return loggedAt;
    }
    public void setLoggedAt(LocalDate loggedAt) {
        this.loggedAt = loggedAt;
    }
    public ScoreAuditLog(int scoreChange, String reason, LocalDate loggedAt) {
        this.scoreChange = scoreChange;
        this.reason = reason;
        this.loggedAt = loggedAt;
    }
    public ScoreAuditLog() {
    }


}
