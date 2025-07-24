package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Login;
import com.example.demo.entity.LoginResult;
import com.example.demo.service.LoginService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class LoginController {
	
	@Autowired
    private final LoginService loginService;
	
	@GetMapping("/login")
	public String showLoginTop() {
		return "login";
	}
	

	
	@PostMapping("/top")
	public String checkLogin(
	        @RequestParam String id,
	        @RequestParam String pass,
	        Model model) {

	    Login login = new Login(id, pass);
	    LoginResult lr = loginService.checkLogin(login);

	    if (lr.isActive()) {
	        model.addAttribute("authority", lr.getAuthority());
	        model.addAttribute("id", id);  
	        return "top";
	    } else {
	        model.addAttribute("errorMessage", "ユーザーIDまたはパスワードが間違っています。");
	        return "login";
	    }
	}
			
			//	@PostMapping("/login")
			//	public String checkLogin(@ModelAttribute LoginForm form, Model model) {
			//		
			//		 Login login = new Login(form.getId(), form.getPass());
			////		 LoginResult lr = new LoginResult();
			////		 lr.setActive(true);
			////		 lr.setRole(null);
			//		 LoginResult lr=loginService.checkLogin(login);
			//		 
			//		 // ログイン処理の成否によって処理を分岐
			//	        if (lr.isActive()) { // ログイン成功時
			//	            // Modelにユーザー情報を追加
			//	            model.addAttribute("role", lr.getRole());
			//	            return "top";
			//	            
			//	        } else { // ログイン失敗時
			//	            model.addAttribute("errorMessage", "ユーザーIDまたはパスワードが間違っています。");
			//	            return "login";
			//	        }
			//		
			//	}
	
}
