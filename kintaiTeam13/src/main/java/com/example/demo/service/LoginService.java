package com.example.demo.service;

import com.example.demo.entity.Employee;
import com.example.demo.entity.Login;

public interface LoginService {
	
	Employee execute(Login login);

}
