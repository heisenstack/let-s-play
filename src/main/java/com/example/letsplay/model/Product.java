package com.example.letsplay.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;

@Data
@Document(collection = "products")
public class Product {

    @Id
    private String id;

    private String name;

    private String description;

    private Double price;

    private String userId;
    private String author; 

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}