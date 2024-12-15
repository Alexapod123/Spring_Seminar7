package com.example.sem7.controller;

import com.example.sem7.service.JwtTokenService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    private final JwtTokenService tokenService;
    @Autowired
    public TestController(JwtTokenService tokenService) {
        this.tokenService = tokenService;
    }

    @GetMapping("/hello")
    public ResponseEntity<String> test (HttpServletRequest httpServletRequest){
        int userId = tokenService.getIdUserFromToken(httpServletRequest);
        return new ResponseEntity<>("Hello!!" + userId, HttpStatus.OK);
    }
}
