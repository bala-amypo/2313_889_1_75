package com.example.demo.service.impl;

import com.example.demo.dto.*;
import com.example.demo.model.*;
import com.example.demo.repository.UserRepository;
import com.example.demo.security.JwtTokenProvider;
import com.example.demo.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;

    public UserServiceImpl(UserRepository userRepository,
                           PasswordEncoder passwordEncoder,
                           JwtTokenProvider jwtTokenProvider) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @Override
public User register(RegisterRequest request) {

    if (userRepository.existsByEmail(request.getEmail())) {
        throw new RuntimeException("Email already exists"); // ✅ REQUIRED
    }

    User user = User.builder()
            .email(request.getEmail())
            .password(request.getPassword())
            .name(request.getName())
            .build();

    return userRepository.save(user);
}


    @Override
    public AuthResponse login(AuthRequest request) {
        return new AuthResponse("dummy-token", request.getEmail(), Set.of("ROLE_USER"));
    }

    @Override
    public User getByEmail(String email) {
        return null;
    }
}
