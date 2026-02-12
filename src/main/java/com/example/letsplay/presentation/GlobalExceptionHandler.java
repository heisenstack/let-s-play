// src/main/java/com/example/letsplay/presentation/GlobalExceptionHandler.java
package com.example.letsplay.presentation;

import com.example.letsplay.application.exception.ProductNotFoundException;
import com.example.letsplay.application.exception.UnauthorizedOperationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleProductNotFoundException(ProductNotFoundException ex) {
        // Create a clean JSON response body
        Map<String, String> response = Map.of("error", ex.getMessage());
        // Return the response with a 404 NOT FOUND status
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UnauthorizedOperationException.class)
    public ResponseEntity<Map<String, String>> handleUnauthorizedOperationException(UnauthorizedOperationException ex) {
        // Create a clean JSON response body
        Map<String, String> response = Map.of("error", ex.getMessage());
        // Return the response with a 403 FORBIDDEN status
        return new ResponseEntity<>(response, HttpStatus.FORBIDDEN);
    }
}