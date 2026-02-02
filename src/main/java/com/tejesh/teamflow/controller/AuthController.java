package com.tejesh.teamflow.controller;

import com.tejesh.teamflow.dto.SignupRequest;
import com.tejesh.teamflow.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }
    
    // 🔴 SIGNUP ENDPOINT
    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody SignupRequest request) {
        System.out.println("REGISTER API HIT");
        authService.register(request);
        return ResponseEntity.ok("User registered successfully");
    }
}
