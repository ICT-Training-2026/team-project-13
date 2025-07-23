package com.example.demo.entity;

import lombok.Data;

@Data
public class User {
  
	private Integer employeeId;
	private String name;
	private Integer departmentId;
	private String pass;
	private String authority;
}
