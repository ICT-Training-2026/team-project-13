package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.form.AccountForm;
import com.example.demo.service.LoginService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class LoginController {
	
	@Autowired
	private final LoginService service;
	
	@GetMapping("/login")
	public String showLoginTop(@ModelAttribute AccountForm form) {
		return "login";
	}
	
	@PostMapping("/login")
	public String checkLogin(@ModelAttribute AccountForm form,Model model) {
		
//		 Login login = new Login(form.getId(), form.getPass());
		
//		 Employee employee = service.execute(login);
//         // ログイン処理の成否によって処理を分岐
//         if (employee.isActive()) { // ログイン成功時
//            // Modelにユーザー情報を追加
//            model.addAttribute("role", );
//
//            // RestaurantSearchFormのインスタンスを作成してモデルに追加
//            RestaurantSearchForm form = new RestaurantSearchForm();
//            model.addAttribute("form", form);
//
//            return "restaurant-list";
//        } else { // ログイン失敗時
//            model.addAttribute("errorMessage", "ユーザーIDまたはパスワードが間違っています。");
//            return "login";
//        }
		
	    System.out.println("ID: " + form.getId());
	    System.out.println("Password: " + form.getPass());
		return "top";
	}
}
