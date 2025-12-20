
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

    // MANDATORY: The integration test specifically calls this constructor
    public AuthResponse(String token) {
        this.token = token;
    }
}