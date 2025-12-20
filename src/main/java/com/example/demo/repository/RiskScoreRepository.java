package com.example.demo.repository;

import com.example.demo.model.RiskScore;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface RiskScoreRepository extends JpaRepository<RiskScore, Long> {
    // Required for findByVisitorId calls in your Service
    Optional<RiskScore> findByVisitorId(Long visitorId);
}