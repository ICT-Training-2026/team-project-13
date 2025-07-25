package com.example.demo;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class UserSession {
    private String id;
    private String authority;
}