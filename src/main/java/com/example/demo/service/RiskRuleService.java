package com.example.demo.service;

import java.util.List;

import com.example.demo.model.RiskRule;


public interface RiskRuleService {
    RiskRule postdate(RiskRule st);
    List<RiskRule>getdata();
    RiskRule getidvalue(Long id);
    

}
