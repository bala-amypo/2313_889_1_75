package com.example.demo.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import com.example.demo.model.RiskScore;
import com.example.demo.service.RiskScoreService;

@RestController
@RequestMapping("/api/risk-scores")
public class RiskScoreController {

    private final RiskScoreService src;

    public RiskScoreController( RiskScoreService src) { this.src = src; }

    @PostMapping("/post")
    public RiskScore insertdata(@RequestBody RiskScore st) { return src.postdata(st); }

    @GetMapping("/get")
    public List<RiskScore> wantData() { return src.getdata(); }

    @GetMapping("/getid/{id}")
    public RiskScore particulardata(@PathVariable Long id) { return src.getidvalue(id); }
}
