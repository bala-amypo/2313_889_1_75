import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "visitors")
public class Visitor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String fullName;

    @Column
    private String email;   // optional

    @Column(nullable = false)
    private String phone;

    @Column(nullable = false)
    private String idProof;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    // Auto set createdAt
    @PrePersist
    public void onCreate() {
        if (phone == null || phone.trim().isEmpty()) {
            throw new RuntimeException("phone required");
        }
        this.createdAt = LocalDateTime.now();
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        if (fullName == null || fullName.isEmpty()) {
            throw new RuntimeException("fullName required");
        }
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        if (phone == null || phone.isEmpty()) {
            throw new RuntimeException("phone required");
        }
        this.phone = phone;
    }

    public String getIdProof() {
        return idProof;
    }

    public void setIdProof(String idProof) {
        if (idProof == null || idProof.isEmpty()) {
            throw new RuntimeException("idProof required");
        }
        this.idProof = idProof;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
