package com.example.demo.service.serviceImpl;

import java.util.List;
import org.springframework.stereotype.Service;
import com.example.demo.model.Visitor;
import com.example.demo.repository.VisitorRepository;
import com.example.demo.service.VisitorService;

@Service
public class VisitorServiceImpl implements VisitorService {

    private final VisitorRepository rep;

    public VisitorServiceImpl(VisitorRepository rep) { this.rep = rep; }

    @Override
    public Visitor postdata(Visitor st) { return rep.save(st); }

    @Override
    public List<Visitor> getdata() { return rep.findAll(); }

    @Override
    public Visitor getidvalue(Long id) {
        return rep.findById(id)
                  .orElseThrow(() -> new RuntimeException("Visitor not found with id: " + id));
    }
}
