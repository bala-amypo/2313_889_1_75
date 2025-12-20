package com.example.demo.security;

import org.springframework.stereotype.Component;
import java.util.Set;

@Component
public class JwtTokenProvider {
    
    // Change first parameter to String email to match the test calls
    public String createToken(String email, Set<String> roles) {
        // Implementation logic for JWT generation
        return "generated-jwt-token"; 
    }
}