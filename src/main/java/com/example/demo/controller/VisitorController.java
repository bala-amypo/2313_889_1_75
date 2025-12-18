package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Visitor;
import com.example.demo.service.VisitorService;

@RestController
@RequestMapping("/api/visitors")
public class VisitorController {

    private final VisitorService src;

    public VisitorController(VisitorService src) {
        this.src = src;
    }

    @PostMapping("/post")
    public Visitor insertData(@RequestBody Visitor st) {
        return src.postdata(st);
    }

    @GetMapping("/get")
    public List<Visitor> wantData() {
        return src.getdata();
    }

    @GetMapping("/getid/{id}")
    public Visitor particularData(@PathVariable Long id) {
        return src.getidvalue(id);
    }
}
