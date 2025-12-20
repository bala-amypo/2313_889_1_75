package com.example.demo.service;

import com.example.demo.model.VisitLog;
import java.util.List;

public interface VisitLogService {
    VisitLog create(Long visitorId, VisitLog log);
    VisitLog listByVisitor(Long id);
    List<VisitLog> get(Long visitorId);
}