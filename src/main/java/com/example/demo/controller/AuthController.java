package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;
import com.example.demo.model.User;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("/api/users")
public class AuthController {

    private final UserService src;

    public AuthController(UserService src) { this.src = src; }

    @PostMapping("/post")
    public User insertdata(@RequestBody User st) { return src.postdata(st); }
}
