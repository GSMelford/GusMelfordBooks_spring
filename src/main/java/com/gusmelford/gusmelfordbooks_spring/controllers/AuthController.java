package com.gusmelford.gusmelfordbooks_spring.controllers;

import com.gusmelford.gusmelfordbooks_spring.mappers.JwtMapper;
import com.gusmelford.gusmelfordbooks_spring.payload.dto.JwtDto;
import com.gusmelford.gusmelfordbooks_spring.payload.request.UserLoginCredentials;
import com.gusmelford.gusmelfordbooks_spring.payload.request.UserRegistrationData;
import com.gusmelford.gusmelfordbooks_spring.services.interfaces.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class AuthController {
    private final AuthService authService;
    private final JwtMapper jwtMapper;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody UserRegistrationData userRegistrationData){
        authService.register(userRegistrationData);
        return ResponseEntity.ok("User registered successfully");
    }

    @PostMapping("/admin/register")
    public ResponseEntity<String> registerAdmin(@RequestBody UserRegistrationData userRegistrationData){
        authService.registerAdmin(userRegistrationData);
        return ResponseEntity.ok("Admin registered successfully");
    }

    @PostMapping("/login")
    public ResponseEntity<JwtDto> login(@RequestBody UserLoginCredentials userLoginCredentials){
        return ResponseEntity.ok(jwtMapper.toDto(authService.login(userLoginCredentials)));
    }
}
