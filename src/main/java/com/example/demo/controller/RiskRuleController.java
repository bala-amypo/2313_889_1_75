package com.example.demo.controller;

import com.example.demo.model.RiskRule;
import com.example.demo.service.RiskRuleService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/risk-rules")
@Tag(name = "RiskRule")
public class RiskRuleController {
    private final RiskRuleService service;

    public RiskRuleController(RiskRuleService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<RiskRule> create(@RequestBody RiskRule rule) {
        return new ResponseEntity<>(service.createRule(rule), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RiskRule> get(@PathVariable Long id) {
        return ResponseEntity.ok(service.getRule(id));
    }

    @GetMapping
    public ResponseEntity<List<RiskRule>> all() {
        return ResponseEntity.ok(service.getAllRules());
    }
}