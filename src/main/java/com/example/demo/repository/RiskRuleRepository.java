package com.example.demo.repository;

import com.example.demo.model.RiskRule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RiskRuleRepository extends JpaRepository<RiskRule, Long> {
    // Add this line to fix the error
    boolean existsByRuleName(String ruleName);
}