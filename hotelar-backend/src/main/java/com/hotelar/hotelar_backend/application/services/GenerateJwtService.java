package com.hotelar.hotelar_backend.application.services;

import com.hotelar.hotelar_backend.domain.models.User;
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
    
    private static final String SECRET_KEY = "SECRET_KEY";

    public String tokenWithoutClaims(User user){
        return tokenWithClaims(new HashMap<>(), user.getEmail());
    }

    private String tokenWithClaims(Map<String, Object> claims, String subject){
        return Jwts
                .builder()
                .setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24))
                .signWith(key(), SignatureAlgorithm.HS256)
                .compact();
    }

    private Key key(){
        return Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
    }
}
