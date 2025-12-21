package com.example.demo.service;

import java.util.List;
import com.example.demo.model.VisitLog;

public interface VisitLogService {
    VisitLog postdata(VisitLog st);
    List<VisitLog> getdata();
    VisitLog getidvalue(Long id);
}
