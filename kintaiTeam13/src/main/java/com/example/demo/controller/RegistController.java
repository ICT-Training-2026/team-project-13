package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class RegistController {
	
	@GetMapping("/user_regist")
	public String userRegist() {
		return "user_regist";
	}
	
	@PostMapping("/stamp_regist")
	public String stampRegist(@RequestParam String id, Model model) {
	    model.addAttribute("id", id);
	    
	  
	    return "stamp_regist";
	}

}
