package com.example.demo.controller;

import com.example.demo.model.ScoreAuditLog;
import com.example.demo.service.ScoreAuditLogService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/score-logs")
@Tag(name = "Score Audit Log Controller")
public class ScoreAuditLogController {
    private final ScoreAuditLogService auditLogService;

    public ScoreAuditLogController(ScoreAuditLogService auditLogService) {
        this.auditLogService = auditLogService;
    }

    @PostMapping("/{visitorId}/{ruleId}")
    public ResponseEntity<ScoreAuditLog> (@PathVariable Long visitorId, 
                                                        @PathVariable Long ruleId, 
                                                        @RequestBody ScoreAuditLog log) {
        return ResponseEntity.ok(auditLogService.logScoreChange(visitorId, ruleId, log));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ScoreAuditLog> get(@PathVariable Long id) {
        return ResponseEntity.ok(auditLogService.get(id));
    }

    @GetMapping("/visitor/{visitorId}")
    public ResponseEntity<List<ScoreAuditLog>> logsByVisitor(@PathVariable Long visitorId) {
        return ResponseEntity.ok(auditLogService.logsByVisitor(visitorId));
    }
}