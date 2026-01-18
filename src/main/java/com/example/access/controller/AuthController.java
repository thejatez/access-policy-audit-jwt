package com.example.access.controller;
import com.example.access.security.JwtUtil;
import org.springframework.web.bind.annotation.*;
import java.util.Map;
@RestController
@RequestMapping("/api/auth")
public class AuthController{
@PostMapping("/login")
public Map<String,String> login(@RequestBody Map<String,String> body){
return Map.of("token",JwtUtil.generateToken(body.get("userId"),body.get("role")));
}}