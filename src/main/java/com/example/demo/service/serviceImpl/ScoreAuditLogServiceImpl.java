package com.example.demo.service.impl;

import com.example.demo.exception.BadRequestException;
import com.example.demo.model.ScoreAuditLog;
import com.example.demo.repository.ScoreAuditLogRepository;
import com.example.demo.service.ScoreAuditLogService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ScoreAuditLogServiceImpl implements ScoreAuditLogService {
    private final ScoreAuditLogRepository repository;

    public ScoreAuditLogServiceImpl(ScoreAuditLogRepository repository) {
        this.repository = repository;
    }

    @Override
    public ScoreAuditLog logScoreChange(Long visitorId, Long ruleId, ScoreAuditLog log) {
        if (log.getReason() == null || log.getReason().trim().isEmpty()) {
            throw new BadRequestException("reason required");
        }
        return repository.save(log);
    }

    @Override
    public List<ScoreAuditLog> getLogsByVisitor(Long visitorId) {
        return repository.findByVisitorId(visitorId);
    }

    @Override
    public ScoreAuditLog getLog(Long id) {
        return repository.findById(id).orElse(null);
    }
}