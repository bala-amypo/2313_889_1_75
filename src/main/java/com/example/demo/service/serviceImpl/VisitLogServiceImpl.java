package com.example.demo.service.serviceImpl;

import java.util.List;
import org.springframework.stereotype.Service;
import com.example.demo.model.VisitLog;
import com.example.demo.repository.VisitLogRepository;
import com.example.demo.service.VisitLogService;

@Service
public class VisitLogServiceImpl implements VisitLogService {

    private final VisitLogRepository rep;

    public VisitLogServiceImpl(VisitLogRepository rep) {
        this.rep = rep;
    }

    @Override
    public VisitLog postdata(VisitLog st) {
        return rep.save(st);
    }

    @Override
    public List<VisitLog> getdata() {
        return rep.findAll();
    }

    @Override
    public VisitLog getidvalue(Long id) {
        return rep.findById(id)
                .orElseThrow(() -> new RuntimeException("VisitLog not found with id: " + id));
    }
}
