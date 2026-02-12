// src/main/java/com/example/letsplay/presentation/ProductController.java
package com.example.letsplay.presentation;

import com.example.letsplay.application.ProductService;
import com.example.letsplay.application.dto.CreateProductRequest;
import com.example.letsplay.application.dto.ProductDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus; 
import org.springframework.web.bind.annotation.PostMapping; 
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import java.security.Principal;
import com.example.letsplay.application.dto.UpdateProductRequest; // 1. Add import
import org.springframework.web.bind.annotation.PathVariable; // 2. Add import
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.http.HttpStatus; // 1. Add import
import org.springframework.http.ResponseEntity; // 2. Add import
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<ProductDto> getAllProducts() {
        return productService.getAllProducts();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductDto createProduct(@RequestBody CreateProductRequest request, Principal principal) {
    // 3. Pass the user's name (which is their email) to the service
    return productService.createProduct(request, principal.getName());
}
@PutMapping("/{productId}")
public ProductDto updateProduct(
        @PathVariable String productId,
        @RequestBody UpdateProductRequest request,
        Principal principal) {
    return productService.updateProduct(productId, request, principal.getName());
}
@DeleteMapping("/{productId}")
public ResponseEntity<Void> deleteProduct(@PathVariable String productId, Principal principal) {
    productService.deleteProduct(productId, principal.getName());
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
}
}