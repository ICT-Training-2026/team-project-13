package com.example.demo.entity;

import lombok.Data;

@Data
public class Employee {
	
	    private int employee_id; // ユーザーID
	    private String password; // ハッシュ化されたパスワード
	    private String role; // ユーザーの権限
	    private boolean active; // ユーザーが有効かどうか

	
}
