import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "risk_scores")
public class RiskScore {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(optional = false)
    @JoinColumn(name = "visitor_id")
    private Visitor visitor;

    @Column(nullable = false)
    private Integer totalScore;

    @Column(nullable = false)
    private String riskLevel; 
    // LOW / MEDIUM / HIGH / CRITICAL

    @Column(nullable = false)
    private LocalDateTime evaluatedAt;

    @PrePersist
    @PreUpdate
    public void evaluateRisk() {
        if (totalScore == null || totalScore < 0) {
            throw new RuntimeException("totalScore must be >= 0");
        }

        this.riskLevel = RiskLevelUtils.getRiskLevel(totalScore);
        this.evaluatedAt = LocalDateTime.now();
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public Visitor getVisitor() {
        return visitor;
    }

    public void setVisitor(Visitor visitor) {
        this.visitor = visitor;
    }

    public Integer getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(Integer totalScore) {
        this.totalScore = totalScore;
    }

    public String getRiskLevel() {
        return riskLevel;
    }

    public LocalDateTime getEvaluatedAt() {
        return evaluatedAt;
    }
}
