package com.example.demo.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import com.example.demo.model.RiskRule;
import com.example.demo.service.RiskRuleService;

@RestController
@RequestMapping("/api/risk-rules")
public class RiskRuleController {

    private final RiskRuleService src;

    public RiskRuleController(RiskRuleService src) { this.src = src; }

    @PostMapping("/post")
    public RiskRule insertdata(@RequestBody RiskRule st) { return src.postdata(st); }

    @GetMapping("/get")
    public List<RiskRule> wantData() { return src.getdata(); }

    @GetMapping("/getid/{id}")
    public RiskRule particulardata(@PathVariable Long id) { return src.getidvalue(id); }
}
