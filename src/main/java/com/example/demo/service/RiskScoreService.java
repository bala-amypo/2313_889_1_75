package com.example.demo.service;

import com.example.demo.model.RiskScore;
import java.util.List;

public interface RiskScoreService {
    RiskScore evaluate(Long visitorId);
    RiskScore get(Long visitorId);
    List<RiskScore> all();
}