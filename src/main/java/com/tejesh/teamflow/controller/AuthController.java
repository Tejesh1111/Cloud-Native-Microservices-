package com.tejesh.teamflow.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tejesh.teamflow.dto.LoginRequest;
import com.tejesh.teamflow.dto.LoginResponse;
import com.tejesh.teamflow.dto.SignupRequest;
import com.tejesh.teamflow.service.AuthService;

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
    
    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request)
    {
    	String token=authService.login(request.getEmail(),request.getPassword());
    	return ResponseEntity.ok(new LoginResponse(token));
    }
}
