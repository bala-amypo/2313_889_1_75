
package com.example.demo.service.impl;

import com.example.demo.model.ScoreAuditLog;
import com.example.demo.model.Visitor;
import com.example.demo.model.RiskRule;
import com.example.demo.repository.ScoreAuditLogRepository;
import com.example.demo.repository.VisitorRepository;
import com.example.demo.repository.RiskRuleRepository;
import com.example.demo.service.ScoreAuditLogService;
import com.example.demo.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ScoreAuditLogServiceImpl implements ScoreAuditLogService {
    private final ScoreAuditLogRepository repository;
    private final VisitorRepository visitorRepo;
    private final RiskRuleRepository ruleRepo;

    public ScoreAuditLogServiceImpl(ScoreAuditLogRepository repository, VisitorRepository visitorRepo, RiskRuleRepository ruleRepo) {
        this.repository = repository;
        this.visitorRepo = visitorRepo;
        this.ruleRepo = ruleRepo;
    }

    @Override
    public ScoreAuditLog logScoreChange(Long visitorId, Long ruleId, ScoreAuditLog log) {
        if (log.getReason() == null || log.getReason().trim().isEmpty()) {
            throw new IllegalArgumentException("reason required");
        }
        
        Visitor visitor = visitorRepo.findById(visitorId)
                .orElseThrow(() -> new ResourceNotFoundException("Visitor not found"));
        RiskRule rule = ruleRepo.findById(ruleId)
                .orElseThrow(() -> new ResourceNotFoundException("Rule not found"));
        
        log.setVisitor(visitor);
        log.setAppliedRule(rule);
        return repository.save(log);
    }

    @Override
    public List<ScoreAuditLog> getLogsByVisitor(Long visitorId) {
        return repository.findByVisitorId(visitorId);
    }

    @Override
    public ScoreAuditLog getLog(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Audit log not found"));
    }
}