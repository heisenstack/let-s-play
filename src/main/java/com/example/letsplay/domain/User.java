package com.example.letsplay.domain;


import org.springframework.data.annotation.Id;


public class User {

    @Id
    private String id;
    private String name;
    private String email;
    private String password;
    private String role;
}