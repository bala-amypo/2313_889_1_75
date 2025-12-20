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
    // This MUST be 'roles' (plural) because the test calls setRoles()
    private Set<String> roles; 
}