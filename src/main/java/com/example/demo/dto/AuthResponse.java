package com.example.demo.dto;

import lombok.*;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor // This fixes the "no suitable constructor found" error
public class AuthResponse {
    private String token;
    private String email;
    private Set<String> roles;
}