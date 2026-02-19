package com.example.letsplay.dto;

import lombok.Data;

@Data
public class ProductResponse {
    private String id;
    private String name;
    private String description;
    private Double price;
    private String userId;
}