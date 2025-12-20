package com.example.demo.controller;

import com.example.demo.model.Visitor;
import com.example.demo.service.VisitorService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/visitors")
@Tag(name = "Visitor Controller")
public class VisitorController {
    private final VisitorService visitorService;

    public VisitorController(VisitorService visitorService) {
        this.visitorService = visitorService;
    }

    @PostMapping
    public ResponseEntity<Visitor> create(@RequestBody Visitor visitor) {
        return ResponseEntity.ok(visitorService.create(visitor));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Visitor> get(@PathVariable Long id) {
        return ResponseEntity.ok(visitorService.get(id));
    }

    @GetMapping
    public ResponseEntity<List<Visitor>> all() {
        return ResponseEntity.ok(visitorService.all());
    }
}