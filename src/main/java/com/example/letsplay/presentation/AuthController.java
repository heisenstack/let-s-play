// src/main/java/com/example/letsplay/presentation/AuthController.java
package com.example.letsplay.presentation;

import com.example.letsplay.application.UserService; // 1. Add import
import com.example.letsplay.application.dto.LoginRequest;
import com.example.letsplay.application.dto.LoginResponse;
import com.example.letsplay.application.dto.RegisterRequest; // 2. Add import
import com.example.letsplay.application.dto.UserDto; // 3. Add import
import com.example.letsplay.infrastructure.security.JwtService;
import lombok.RequiredArgsConstructor; // 4. Add import
import org.springframework.http.HttpStatus; // 5. Add import
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor // Use Lombok for a clean constructor
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final UserDetailsService userDetailsService;
    private final JwtService jwtService;
    private final UserService userService; // 6. Add UserService dependency

    // The @RequiredArgsConstructor annotation handles the constructor for us.

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request) {
        // 1. Authenticate the user
        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
        );

        // 2. If authentication is successful, load user details
        final UserDetails userDetails = userDetailsService.loadUserByUsername(request.getEmail());

        // 3. Generate the JWT
        final String jwt = jwtService.generateToken(userDetails);

        // 4. Return the token in the response
        return ResponseEntity.ok(new LoginResponse(jwt));
    }

    // 7. ADD THIS ENTIRE METHOD
    @PostMapping("/register")
    public ResponseEntity<UserDto> register(@RequestBody RegisterRequest request) {
        UserDto createdUser = userService.registerUser(request);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }
}