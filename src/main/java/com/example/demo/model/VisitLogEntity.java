import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "visit_logs")
public class VisitLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "visitor_id")
    private Visitor visitor;

    @Column(nullable = false)
    private LocalDateTime entryTime;

    private LocalDateTime exitTime;

    @Column(nullable = false)
    private String purpose;

    @Column(nullable = false)
    private String location;

    // Auto-generate entryTime
    @PrePersist
    public void onEntry() {
        this.entryTime = LocalDateTime.now();

        if (purpose == null || purpose.isEmpty()) {
            throw new RuntimeException("purpose required");
        }

        if (location == null || location.isEmpty()) {
            throw new RuntimeException("location required");
        }
    }

    // Validate exitTime
    @PreUpdate
    public void validateExitTime() {
        if (exitTime != null && exitTime.isBefore(entryTime)) {
            throw new RuntimeException("exitTime must be after entryTime");
        }
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

    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    public LocalDateTime getExitTime() {
        return exitTime;
    }

    public void setExitTime(LocalDateTime exitTime) {
        this.exitTime = exitTime;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
