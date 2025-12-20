package com.example.demo.controller;

import com.example.demo.model.RiskScore;
import com.example.demo.service.RiskScoreService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller for managing and evaluating visitor risk scores.
 * The @Tag annotation is mandatory for Swagger documentation tests.
 */
@RestController
@RequestMapping("/api/risk-scores")
@Tag(name = "RiskScore")
public class RiskScoreController {

    private final RiskScoreService service;

    // Constructor injection is required for testing
    public RiskScoreController(RiskScoreService service) {
        this.service = service;
    }

    /**
     * Triggers a fresh risk evaluation for a specific visitor.
     * Expected Endpoint: POST /api/risk-scores/evaluate/{visitorId}
     */
    @PostMapping("/evaluate/{visitorId}")
    public ResponseEntity<RiskScore> evaluate(@PathVariable Long visitorId) {
        return ResponseEntity.ok(service.evaluateVisitor(visitorId));
    }

    /**
     * Retrieves the current risk score for a specific visitor.
     * Expected Endpoint: GET /api/risk-scores/{visitorId}
     */
    @GetMapping("/{visitorId}")
    public ResponseEntity<RiskScore> get(@PathVariable Long visitorId) {
        return ResponseEntity.ok(service.getScoreForVisitor(visitorId));
    }

    /**
     * Retrieves all risk scores in the system.
     * Expected Endpoint: GET /api/risk-scores
     */
    @GetMapping
    public ResponseEntity<List<RiskScore>> all() {
        return ResponseEntity.ok(service.getAllScores());
    }
}