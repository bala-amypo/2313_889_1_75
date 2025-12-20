package com.example.demo.service;

import com.example.demo.model.RiskRule;
import java.util.List;

public interface RiskRuleService {
    RiskRule create(RiskRule rule);
    List<RiskRule> all();
    RiskRule get(Long id);
}