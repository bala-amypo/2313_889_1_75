package com.example.demo.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import com.example.demo.model.Visitor;
import com.example.demo.service.VisitorService;

@RestController
@RequestMapping("/api/visitors")
public class VisitorController {

    private final VisitorService src;

    public VisitorController(VisitorService src) { this.src = src; }

    @PostMapping("/post")
    public Visitor insertdata(@RequestBody Visitor st) { return src.postdata(st); }

    @GetMapping("/get")
    public List<Visitor> wantData() { return src.getdata(); }

    @GetMapping("/getid/{id}")
    public Visitor particulardata(@PathVariable Long id) { return src.getidvalue(id); }
}
