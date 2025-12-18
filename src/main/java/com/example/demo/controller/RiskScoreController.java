package com.example.demo.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import com.example.demo.model.ScoreAuditLog;
import com.example.demo.service.ScoreAuditLogService;

@RestController
@RequestMapping("/api/score-logs")
public class ScoreAuditLogController {

    private final ScoreAuditLogService src;

    public ScoreAuditLogController(ScoreAuditLogService src) { this.src = src; }

    @PostMapping("/post")
    public ScoreAuditLog insertdata(@RequestBody ScoreAuditLog st) { return src.postdata(st); }

    @GetMapping("/get")
    public List<ScoreAuditLog> wantData() { return src.getdata(); }

    @GetMapping("/getid/{id}")
    public ScoreAuditLog particulardata(@PathVariable Long id) { return src.getidvalue(id); }
}
