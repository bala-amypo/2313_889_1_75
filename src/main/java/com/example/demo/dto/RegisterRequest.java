package com.example.demo.dto;

import lombok.*;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest {
    private String email;
    private String password;
    // Use 'roles' (plural) to ensure setRoles() works for the test suite
    private Set<String> roles; 
}