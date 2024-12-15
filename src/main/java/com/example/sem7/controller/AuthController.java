package com.example.sem7.controller;

import com.example.sem7.model.User;
import com.example.sem7.service.JwtTokenService;
import com.example.sem7.service.LogInService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final JwtTokenService tokenService;
    private final LogInService logInService;

    public AuthController(JwtTokenService tokenService, LogInService logInService) {
        this.tokenService = tokenService;
        this.logInService = logInService;
    }

    @PostMapping("/login")
    public ResponseEntity<String> login (@RequestBody User user){
        return logInService.login(user)
                .map(userId -> {
                    String token = tokenService.generateToken(userId, "USER");
                    return new ResponseEntity<>("Bearer" + token, HttpStatus.OK);
                }).orElseGet(() -> new ResponseEntity<>(HttpStatus.UNAUTHORIZED));
    }
}
