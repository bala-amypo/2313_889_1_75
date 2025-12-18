package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;
import com.example.demo.model.User;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService src;

    public UserController(UserService src) { this.src = src; }

    @PostMapping("/post")
    public User insertdata(@RequestBody User st) { return src.postdata(st); }
}
