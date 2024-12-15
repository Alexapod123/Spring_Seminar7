package com.example.sem7.service;

import com.example.sem7.model.User;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class LogInService {
    Map<String, String> userMap = new HashMap<>(Map.of("user", "password", "admin", "admin"));
    public Optional<Integer> login(User user){
        String password = userMap.get(user.username());
        if(password!=null&&password.equals(user.password())){
            return Optional.of(1);
        }
        return Optional.empty();
    }
}
