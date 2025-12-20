package com.example.demo.dto;

import lombok.*;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor // REQUIRED: Fixes "no suitable constructor found"
public class AuthResponse {
    private String token;
    private String email;
    private Set<String> roles;
}