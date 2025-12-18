 package com.example.demo.controller;
 package com.example.demo.service;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.ScoreAuditLog;
import com.example.demo.service.ScoreAuditLogService;



@RestController
@RequestMapping("/api/score-logs")
public class ScoreAuditLogController{
    private final ScoreAuditLogService src;

    public ScoreAuditLogController(ScoreAuditLogService src) {
        this.src = src;
    }
    @PostMapping("/post")
    public ScoreAuditLog insertdata(@RequestBody ScoreAuditLog st){
        return src.postdata(st);
    }
    @GetMapping("/get")
    public List<ScoreAuditLog> wantData(){
        return src.getdate();
    }
    @GetMapping("/getid/{id}")
    public ScoreAuditLog particulardata(@PathVariable Long id){
        return src.getidvalue(id);
    }
    
}