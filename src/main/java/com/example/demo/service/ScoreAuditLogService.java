package com.example.demo.service;

import java.util.List;
import com.example.demo.model.ScoreAuditLog;

public interface ScoreAuditLogService {
    ScoreAuditLog postdata(ScoreAuditLog st);
    List<ScoreAuditLog> getdata();
    ScoreAuditLog getidvalue(Long id);
}
