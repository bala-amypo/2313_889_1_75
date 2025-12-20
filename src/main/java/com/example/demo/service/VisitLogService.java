package com.example.demo.service;

import com.example.demo.model.VisitLog;
import java.util.List;

public interface VisitLogService {
    VisitLog create(Long visitorId, VisitLog log);
    VisitLog get(Long id);
    List<VisitLog> listByVisitor(Long visitorId);
}