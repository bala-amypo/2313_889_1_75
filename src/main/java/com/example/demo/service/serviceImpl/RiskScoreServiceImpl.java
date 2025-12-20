package com.example.demo.service.impl;

import com.example.demo.model.RiskScore;
import com.example.demo.repository.RiskScoreRepository;
import com.example.demo.service.RiskScoreService;
import com.example.demo.util.RiskLevelUtils;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class RiskScoreServiceImpl implements RiskScoreService {
    private final RiskScoreRepository scoreRepo;

    public RiskScoreServiceImpl(RiskScoreRepository scoreRepo) {
        this.scoreRepo = scoreRepo;
    }

    @Override
    public RiskScore evaluateVisitor(Long visitorId) {
        // Implementation logic for calculating totalScore from rules goes here
        int totalScore = 0; 

        RiskScore score = scoreRepo.findByVisitorId(visitorId)
                .orElse(new RiskScore());

        score.setTotalScore(Math.max(0, totalScore)); // Ensure totalScore >= 0
        score.setRiskLevel(RiskLevelUtils.determineRiskLevel(score.getTotalScore()));
        score.setEvaluatedAt(LocalDateTime.now());

        return scoreRepo.save(score);
    }

    @Override
    public RiskScore getScoreForVisitor(Long visitorId) {
        return scoreRepo.findByVisitorId(visitorId).orElse(null);
    }

    @Override
    public List<RiskScore> getAllScores() {
        return scoreRepo.findAll();
    }
}