package com.example.access.controller;

import com.example.access.service.AccessService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/access")
public class AccessController {
    private final AccessService s;

    public AccessController(AccessService s) {
        this.s = s;
    }

    @PostMapping("/check")
    public ResponseEntity<Map<String, Object>> check(HttpServletRequest r, @RequestParam String action) {
        boolean allowed = s.checkAccess((String) r.getAttribute("userId"), (String) r.getAttribute("role"), action);
        return ResponseEntity.ok(Map.of("allowed", allowed, "action", action));
    }
}