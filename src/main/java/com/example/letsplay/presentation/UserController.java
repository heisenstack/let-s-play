package com.example.letsplay.presentation;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.example.letsplay.domain.User;

@RestController
@RequestMapping("/api/users")
public class UserController {
    public UserController() {
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public User registerUser(@RequestBody RegisterRequest registerRequest) {
        // return userService.registerUser(registerRequest);
    }
}