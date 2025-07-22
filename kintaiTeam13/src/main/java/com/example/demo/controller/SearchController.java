package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SearchController {
	
	@PostMapping("/search")
	public String stampRegist(@RequestParam String id,@RequestParam String authority, Model model) {
	    model.addAttribute("id", id);
	    model.addAttribute("authority", authority);
	    
	  
	    return "search";
	}

}
