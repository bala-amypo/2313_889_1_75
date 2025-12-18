import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(
    name = "risk_rules",
    uniqueConstraints = {
        @UniqueConstraint(columnNames = "ruleName")
    }
)
public class RiskRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String ruleName;

    @Column(nullable = false)
    private String ruleType; 
    // AFTER_HOURS / FREQUENT_VISITS / BLACKLIST / KEYWORD / CUSTOM

    @Column(nullable = false)
    private Integer threshold;

    @Column(nullable = false)
    private Integer scoreImpact;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    @PrePersist
    public void onCreate() {
        if (threshold == null || threshold < 0) {
            throw new RuntimeException("threshold must be >= 0");
        }
        if (scoreImpact == null || scoreImpact < 0) {
            throw new RuntimeException("scoreImpact must be >= 0");
        }
        this.createdAt = LocalDateTime.now();
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public String getRuleName() {
        return ruleName;
    }

    public void setRuleName(String ruleName) {
        this.ruleName = ruleName;
    }

    public String getRuleType() {
        return ruleType;
    }

    public void setRuleType(String ruleType) {
        this.ruleType = ruleType;
    }

    public Integer getThreshold() {
        return threshold;
    }

    public void setThreshold(Integer threshold) {
        if (threshold < 0) {
            throw new RuntimeException("threshold must be >= 0");
        }
        this.threshold = threshold;
    }

    public Integer getScoreImpact() {
        return scoreImpact;
    }

    public void setScoreImpact(Integer scoreImpact) {
        if (scoreImpact < 0) {
            throw new RuntimeException("scoreImpact must be >= 0");
        }
        this.scoreImpact = scoreImpact;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
