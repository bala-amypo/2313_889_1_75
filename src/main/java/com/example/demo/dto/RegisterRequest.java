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
    // Must be 'roles' (plural) to fix the setRoles() compilation error
    private Set<String> roles; 
}