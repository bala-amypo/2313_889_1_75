package com.example.demo.controller;

import com.example.demo.model.Visitor;
import com.example.demo.service.VisitorService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/visitors")
@Tag(name = "Visitor")
public class VisitorController {
    private final VisitorService service;

    public VisitorController(VisitorService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Visitor> create(@RequestBody Visitor visitor) {
        return new ResponseEntity<>(service.createVisitor(visitor), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Visitor> get(@PathVariable Long id) {
        return ResponseEntity.ok(service.getVisitor(id));
    }

    @GetMapping
    public ResponseEntity<List<Visitor>> all() {
        return ResponseEntity.ok(service.getAllVisitors());
    }
}
