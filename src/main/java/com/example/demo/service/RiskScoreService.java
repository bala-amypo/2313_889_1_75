package com.example.demo.service;

import java.util.List;

import com.example.demo.model.RiskScore;


public interface RiskScoreService {
    RiskScore postdate(RiskScore st);
    List<RiskScore>getdata();
    RiskScore getidvalue(Long id);
    RiskScore postdata(RiskScore st);

}
