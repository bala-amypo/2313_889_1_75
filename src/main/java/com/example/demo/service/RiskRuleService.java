package com.example.demo.service;

import java.util.List;
import com.example.demo.model.RiskRule;

public interface RiskRuleService {
    RiskRule postdata(RiskRule st);
    List<RiskRule> getdata();
    RiskRule getidvalue(Long id);
}
