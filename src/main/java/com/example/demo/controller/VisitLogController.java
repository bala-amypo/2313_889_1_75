package com.example.demo.controller;
 package com.example.demo.service;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.VisitLog;
import com.example.demo.service.VisitLogService;

@RestController
@RequestMapping("/api/visit-logs")
public class VisitLogController {
    private final VisitLogService src;

    public VisitLogController(VisitLog src) {
        this.src = src;
    }
    @PostMapping("/post")
    public VisitLog insertdata(@RequestBody VisitLog st){
        return src.postdata(st);
    }
    @GetMapping("/get")
    public List<VisitLog> wantData(){
        return src.getdata();
    }
    @GetMapping("/getid/{id}")
    public VisitLog particulardata(@PathVariable Long id){
        return src.getidvalue(id);
    }
    
}
