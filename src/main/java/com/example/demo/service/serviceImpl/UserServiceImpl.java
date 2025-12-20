package com.example.demo.service.impl;

import com.example.demo.dto.AuthRequest;
import com.example.demo.dto.AuthResponse;
import com.example.demo.dto.RegisterRequest;
import com.example.demo.exception.BadRequestException;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.security.JwtTokenProvider;
import com.example.demo.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;

    // Constructor injection is mandatory for the test suite
    public UserServiceImpl(UserRepository userRepository, 
                           PasswordEncoder passwordEncoder, 
                           JwtTokenProvider jwtTokenProvider) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @Override
    public User register(RegisterRequest request) {
        // Fix for: cannot find symbol method getEmail()
        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new BadRequestException("Email already exists");
        }

        // Fix for: cannot find symbol method builder()
        User user = User.builder()
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(request.getRoles() != null ? request.getRoles() : new HashSet<>())
                .build();

        return userRepository.save(user);
    }

    @Override
    public AuthResponse login(AuthRequest request) {
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new BadRequestException("Invalid credentials"));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new BadRequestException("Invalid credentials");
        }
        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
        throw new BadRequestException("Invalid credentials");
         }

        String token = jwtTokenProvider.createToken(user.getEmail(), user.getRole());

        // Fix for AuthResponse builder errors
        return AuthResponse.builder()
                .token(token)
                .email(user.getEmail())
                .roles(user.getRole())
                .build();
    }

    /**
     * Fix for: UserServiceImpl is not abstract and does not override 
     * abstract method getByEmail(java.lang.String)
     */
    @Override
    public User getByEmail(String email) {
        return userRepository.findByEmail(email).orElse(null);
    }
}
package com.example.demo.service.impl;

import com.example.demo.dto.*;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.security.JwtTokenProvider;
import com.example.demo.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtTokenProvider jwtTokenProvider) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @Override
    public AuthResponse login(AuthRequest request) {
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("Invalid credentials"));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }

        // Fix: Pass the email (String) and role (Set)
        String token = jwtTokenProvider.createToken(user.getEmail(), user.getRole());

        // Fix: Use the All-Args Constructor or Builder
        return AuthResponse.builder()
                .token(token)
                .email(user.getEmail())
                .roles(user.getRole())
                .build();
    }
    
    // ... rest of your implementation (register, getByEmail, etc.)
}