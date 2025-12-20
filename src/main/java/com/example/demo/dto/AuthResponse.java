package com.example.demo.dto;

import lombok.*;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor // REQUIRED: The test suite calls a constructor with 3 arguments
public class AuthResponse {
    private String token;
    private String email;
    private Set<String> roles;
}