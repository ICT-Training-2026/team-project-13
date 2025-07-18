package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SearchController {
	
//検索リクエスト
	@GetMapping("/search")
	public String searchTop(){
	
		return "search-list";
	}
}
	
	

