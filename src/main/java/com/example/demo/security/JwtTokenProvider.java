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
private final long validityInMilliseconds = 3600000; // 1h

public String createToken(String email, Set<String> roles) {
Claims claims = Jwts.claims().setSubject(email);
claims.put("roles", roles);
Date now = new Date();
Date validity = new Date(now.getTime() + validityInMilliseconds);

return Jwts.builder()
.setClaims(claims)
.setIssuedAt(now)
.setExpiration(validity)
.signWith(SignatureAlgorithm.HS256, secretKey)
.compact();
}

public String getEmail(String token) {
return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody().getSubject();
}

public Claims getClaims(String token) {
return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody();
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