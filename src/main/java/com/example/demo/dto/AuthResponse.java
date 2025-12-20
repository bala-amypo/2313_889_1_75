package com.example.demo.dto;

import lombok.*;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor // This generates the 3-argument constructor needed by the test
public class AuthResponse {
    private String token;
    private String email;
    private Set<String> roles;
}