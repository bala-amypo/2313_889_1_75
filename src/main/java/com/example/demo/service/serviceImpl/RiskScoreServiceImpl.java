package com.example.demo.service.serviceImpl;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.model.RiskScore;
import com.example.demo.repository.RiskScoreRepository;
import com.example.demo.service.RiskScoreService;


@Service
public class RiskScoreServiceImpl implements RiskScoreService {
    private final RiskScoreRepository rep;

    public RiskScoreServiceImpl(RiskScoreRepository rep) {
        this.rep = rep;
    }
    @Override
    public RiskScore postdata(RiskScore st){
        return rep.save(st);
    }
    @Override
    public List<RiskScore> getdata(){
        return rep.findAll();
    }
    @Override
    public RiskScore getidvalue(Long id ){
        return rep.findById(id)
                .orElseThrow(()->new RuntimeException("Student not found with id: " + id));
    }
}
