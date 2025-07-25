package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class RegistController {
	
	@GetMapping("/user_regist")
	public String userRegist() {
		return "user_regist";
	}
	
	

}
