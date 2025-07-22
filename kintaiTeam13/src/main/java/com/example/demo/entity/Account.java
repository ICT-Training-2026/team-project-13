package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account {
    private String employeeId;
    private String name;
    private int departmentId;
    private String password;
    private String authority;
//    private double paidLeaveDays;
}