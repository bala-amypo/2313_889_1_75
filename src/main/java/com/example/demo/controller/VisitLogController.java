package com.example.demo.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import com.example.demo.model.VisitLog;
import com.example.demo.service.VisitLogService;

@RestController
@RequestMapping("/api/visit-logs")
public class VisitLogController {

    private final VisitLogService src;

    public VisitLogController(VisitLogService src) { this.src = src; }

    @PostMapping("/post")
    public VisitLog insertdata(@RequestBody VisitLog st) { return src.postdata(st); }

    @GetMapping("/get")
    public List<VisitLog> wantData() { return src.getdata(); }

    @GetMapping("/getid/{id}")
    public VisitLog particulardata(@PathVariable Long id) { return src.getidvalue(id); }
}
