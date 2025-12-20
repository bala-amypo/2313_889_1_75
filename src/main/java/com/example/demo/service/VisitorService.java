package com.example.demo.service;

import com.example.demo.model.Visitor;
import java.util.List;

public interface VisitorService {
    Visitor create(Visitor visitor);
    Visitor get(Long id);
    List<Visitor> getAllVisitors();
}