package com.example.demo.service.serviceImpl;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;



@Service
public class UserServiceImpl implements UserService {
    private final UserRepository rep;

    public UserServiceImpl(UserRepository rep) {
        this.rep = rep;
    }
    @Override
    public User postdata(User st){
        return rep.save(st);
    }
   
}
