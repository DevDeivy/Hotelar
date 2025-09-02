package com.hotelar.hotelar_backend.application.services;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class GenerateJwtService {
    
    private static final String SECRET_KEY = "{{secretKey}}";

    public String tokenWithoutClaims(UserDetails userDetails){
        return tokenWithClaims(new HashMap<>(), userDetails);
    }

    private String tokenWithClaims(Map<String, Object> claims, UserDetails userDetails){
        return Jwts
                .builder()
                .setClaims(claims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24))
                .signWith(key(), SignatureAlgorithm.HS256)
                .compact();
    }
    
    private Key key(){
        return Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
    }
}
