package com.example.demo.service.impl;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.RiskScore;
import com.example.demo.model.Visitor;
import com.example.demo.repository.RiskScoreRepository;
import com.example.demo.repository.VisitorRepository;
import com.example.demo.service.RiskScoreService;
import com.example.demo.util.RiskLevelUtils;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class RiskScoreServiceImpl implements RiskScoreService {
    private final RiskScoreRepository scoreRepo;
    private final VisitorRepository visitorRepo;

    public RiskScoreServiceImpl(RiskScoreRepository scoreRepo, VisitorRepository visitorRepo) {
        this.scoreRepo = scoreRepo;
        this.visitorRepo = visitorRepo;
    }

    @Override
    public RiskScore evaluateVisitor(Long visitorId) {
        Visitor visitor = visitorRepo.findById(visitorId)
                .orElseThrow(() -> new ResourceNotFoundException("Visitor not found"));

        // Placeholder for scoring engine logic
        int totalScore = 0; 
        if (totalScore < 0) totalScore = 0;

        RiskScore score = scoreRepo.findByVisitorId(visitorId)
                .orElse(RiskScore.builder().visitor(visitor).build());

        score.setTotalScore(totalScore);
        score.setRiskLevel(RiskLevelUtils.determineRiskLevel(totalScore));
        score.setEvaluatedAt(LocalDateTime.now());

        return scoreRepo.save(score);
    }

    @Override
    public RiskScore getScoreForVisitor(Long visitorId) {
        return scoreRepo.findByVisitorId(visitorId)
                .orElseThrow(() -> new ResourceNotFoundException("Score not found"));
    }

    @Override
    public List<RiskScore> getAllScores() {
        return scoreRepo.findAll();
    }
}