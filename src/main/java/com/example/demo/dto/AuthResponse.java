package com.example.demo.dto;

import lombok.*;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor 
public class AuthResponse {
    private String token;
    private String email;
    private Set<String> roles;

    // ADD THIS CONSTRUCTOR: The test specifically looks for this
    public AuthResponse(String token) {
        this.token = token;
    }
}