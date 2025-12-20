package com.example.demo.service.impl;

import com.example.demo.exception.BadRequestException;
import com.example.demo.model.Visitor;
import com.example.demo.repository.VisitorRepository;
import com.example.demo.service.VisitorService;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class VisitorServiceImpl implements VisitorService {
    private final VisitorRepository repository;

    public VisitorServiceImpl(VisitorRepository repository) {
        this.repository = repository;
    }

    @Override
    public Visitor createVisitor(Visitor visitor) {
        if (visitor.getPhone() == null || visitor.getPhone().trim().isEmpty()) {
            throw new BadRequestException("phone required");
        }
        return repository.save(visitor);
    }

    @Override
    public List<Visitor> getAllVisitors() {
        List<Visitor> list = repository.findAll();
        return list != null ? list : new ArrayList<>();
    }

    @Override
    public Visitor getVisitor(Long id) {
        return repository.findById(id).orElse(null);
    }
}