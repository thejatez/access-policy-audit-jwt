package com.example.access.security;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import java.security.Key;
import java.util.Date;
import java.util.Map;
public class JwtUtil{
private static final Key key=Keys.secretKeyFor(SignatureAlgorithm.HS256);
public static String generateToken(String userId,String role){
return Jwts.builder().setClaims(Map.of("userId",userId,"role",role))
.setIssuedAt(new Date())
.setExpiration(new Date(System.currentTimeMillis()+3600000))
.signWith(key).compact();
}
public static Claims parseToken(String token){
return Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token).getBody();
}}