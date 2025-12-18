package com.example.demo.service.serviceImpl;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.model.RiskRule;
import com.example.demo.repository.RiskRuleRepository;
import com.example.demo.service.RiskRuleService;

@Service
public class RiskRuleServiceImpl implements RiskRuleService {
    private final RiskRuleRepository rep;

    public RiskRuleServiceImpl(RiskRuleRepository rep) {
        this.rep = rep;
    }
    @Override
    public RiskRule postdata(RiskRule st){
        return rep.save(st);
    }
    @Override
    public List<RiskRule> getdata(){
        return rep.findAll();
    }
    @Override
    public RiskRule getidvalue(Long id ){
        return rep.findById(id)
                .orElseThrow(()->new RuntimeException("Student not found with id: " + id));
    }
}
