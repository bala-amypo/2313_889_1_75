package com.example.demo.service.impl;

import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.RiskRule;
import com.example.demo.repository.RiskRuleRepository;
import com.example.demo.service.RiskRuleService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RiskRuleServiceImpl implements RiskRuleService {
    private final RiskRuleRepository repository;

    public RiskRuleServiceImpl(RiskRuleRepository repository) {
        this.repository = repository;
    }

    @Override
    public RiskRule createRule(RiskRule rule) {
        if (repository.findByRuleName(rule.getRuleName()).isPresent()) {
            throw new BadRequestException("Rule name must be unique");
        }
        return repository.save(rule);
    }

    @Override
    public List<RiskRule> getAllRules() {
        return repository.findAll();
    }

    @Override
    public RiskRule getRule(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Rule not found"));
    }
}