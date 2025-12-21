package com.example.demo.service;

import java.util.List;
import com.example.demo.model.RiskScore;

public interface RiskScoreService {
    RiskScore postdata(RiskScore st);
    List<RiskScore> getdata();
    RiskScore getidvalue(Long id);
}
