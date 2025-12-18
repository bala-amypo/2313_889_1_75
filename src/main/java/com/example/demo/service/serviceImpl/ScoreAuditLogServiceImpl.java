package com.example.demo.service.serviceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.ScoreAuditLog;
import com.example.demo.repository.ScoreAuditLogRepository;
import com.example.demo.service.ScoreAuditLogService;

@Service
public class ScoreAuditLogServiceImpl implements ScoreAuditLogService {

    private final ScoreAuditLogRepository rep;

    public ScoreAuditLogServiceImpl(ScoreAuditLogRepository rep) {
        this.rep = rep;
    }

    @Override
    public ScoreAuditLog postdata(ScoreAuditLog st) {
        return rep.save(st);
    }

    @Override
    public List<ScoreAuditLog> getdata() {
        return rep.findAll();
    }

    @Override
    public ScoreAuditLog getidvalue(Long id) {
        return rep.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("ScoreAuditLog not found with id: " + id));
    }
}
