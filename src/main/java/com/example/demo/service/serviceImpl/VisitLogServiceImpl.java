package com.example.demo.service.impl;

import com.example.demo.exception.BadRequestException;
import com.example.demo.model.VisitLog;
import com.example.demo.repository.VisitLogRepository;
import com.example.demo.service.VisitLogService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class VisitLogServiceImpl implements VisitLogService {
    private final VisitLogRepository logRepo;

    public VisitLogServiceImpl(VisitLogRepository logRepo) {
        this.logRepo = logRepo;
    }

    @Override
    public VisitLog createVisitLog(Long visitorId, VisitLog log) {
        if (log.getExitTime() != null && log.getEntryTime() != null && 
            log.getExitTime().isBefore(log.getEntryTime())) {
            throw new BadRequestException("exitTime must be after entryTime");
        }
        return logRepo.save(log);
    }

    @Override
    public List<VisitLog> getLogsByVisitor(Long visitorId) {
        return logRepo.findByVisitorId(visitorId);
    }

    @Override
    public VisitLog getLog(Long id) {
        return logRepo.findById(id).orElse(null);
    }
}