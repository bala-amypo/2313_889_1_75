package com.example.demo.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final UserService src;

    public AuthController(UserService src) {
        this.src = src;
    }

    @PostMapping("/post")
    public User insertdata(@RequestBody User st) {
        return src.postdata(st);
    }
}
