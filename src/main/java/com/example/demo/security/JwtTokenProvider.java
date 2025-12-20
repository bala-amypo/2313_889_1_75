package com.example.demo.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;
import java.util.Date;
import java.util.Set;

@Component
public class JwtTokenProvider {
    private final String secretKey = "VisitorRiskSecretKeyForTestingPurposeOnlyChangeInProduction";
    private final long validityInMilliseconds = 3600000; 

    // REQUIRED SIGNATURE: It must handle the (long, String, Set) call from the test
    public String createToken(long id, String email, Set<String> roles) {
        Claims claims = Jwts.claims().setSubject(email);
        claims.put("roles", roles);
        claims.put("userId", id); // Store the ID in the token
        Date now = new Date();
        Date validity = new Date(now.getTime() + validityInMilliseconds);

        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(validity)
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
    }
    
    // OVERLOAD: Keep your original version so UserServiceImpl doesn't break
    public String createToken(String email, Set<String> roles) {
        return createToken(0L, email, roles);
    }

    // MANDATORY: The test calls this method directly to verify the token
    public Claims getClaims(String token) {
        return Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(token)
                .getBody();
    }

    public String getEmail(String token) {
        return getClaims(token).getSubject();
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}