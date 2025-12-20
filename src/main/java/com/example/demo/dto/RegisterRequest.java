
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
    // Must be plural 'roles' to match the test's setRoles() call
    private Set<String> roles; 
}