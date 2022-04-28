package com.fruits.congtyhoaqua.utils;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class JwtUtil {

    private final String SECCRET_KEY = "1231231";

    private final Integer TIME_EXPIRATION = 864000;

    public String extractUsername(String token){
        return Jwts.parser().setSigningKey(SECCRET_KEY).parseClaimsJws(token).getBody().getSubject();
    }

    public Date extractExpiration(String token){
        return Jwts.parser().setSigningKey(SECCRET_KEY).parseClaimsJws(token).getBody().getExpiration();
    }

    public Boolean isTokenExpired(String token){
        return extractExpiration(token).before(new Date());
    }

    public Boolean validateToken(String token, UserDetails userDetails){
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername())&& !isTokenExpired(token));
    }

    public String generateToken(UserDetails userDetails){
         return Jwts.builder().setSubject(userDetails.getUsername())
                 .setIssuedAt(new Date(System.currentTimeMillis()))
                 .setExpiration(new Date(System.currentTimeMillis() + TIME_EXPIRATION))
                 .signWith(SignatureAlgorithm.HS256, SECCRET_KEY).compact();
    }
}
