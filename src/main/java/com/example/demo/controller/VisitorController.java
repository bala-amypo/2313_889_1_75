 package com.example.demo.controller;
 package com.example.demo.service;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Visitor;

@RestController
@RequestMapping("/api/visitors")
public class VisitorController {
    private final VisitorService src;

    public VisitorController(VisitorService src) {
        this.src = src;
    }
    @PostMapping("/post")
    public Visitor insertdata(@RequestBody Visitor st){
        return src.postdat(st);
    }
    @GetMapping("/get")
    public List<Visitor> wantData(){
        return src.getdate();
    }
    @GetMapping("/getid/{id}")
    public Visitor particulardata(@PathVariable Long id){
        return src.getidvalue(id)
    }
    
}