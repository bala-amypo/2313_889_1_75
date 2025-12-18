package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Visitor;

public interface VisitorService {

    Visitor postdate(Visitor st);
    List<Visitor>getdata();
    Visitor getidvalue(Long id);

}