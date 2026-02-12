package com.example.letsplay.domain;

import org.springframework.data.annotation.Id;

public class Product {
    @Id
    private String id;
    private String name;
    private String description;
    private double price;
    private String userId;
}