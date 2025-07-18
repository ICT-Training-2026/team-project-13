package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
	//検索リクエスト
		@GetMapping("/")
		public String login(){
			return "login";
		}
}
