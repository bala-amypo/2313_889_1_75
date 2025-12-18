package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.RiskScore;
import com.example.demo.service.RiskScoreService;

@RestController
@RequestMapping("/api/risk-scores")
public class RiskScoreController {

    private final RiskScoreService src;

    public RiskScoreController(RiskScoreService src) {
        this.src = src;
    }

    @PostMapping("/post")
    public RiskScore insertData(@RequestBody RiskScore st) {
        return src.postdata(st);
    }

    @GetMapping("/get")
    public List<RiskScore> wantData() {
        return src.getdate();
    }

    @GetMapping("/getid/{id}")
    public RiskScore particularData(@PathVariable Long id) {
        return src.getidvalue(id);
    }
}
