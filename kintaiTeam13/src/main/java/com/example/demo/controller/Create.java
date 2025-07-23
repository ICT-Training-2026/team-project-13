package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.form.CreateForm;

@Controller
public class Create {
  
	/*新規登録画面表示リクエスト
	 
	 */
	@GetMapping("/show-user-form")
	public String showUserForm(@ModelAttribute CreateForm form) {
		return "create_user";
	}
	
	/*新規登録リクエスト（確認画面からの戻り）*/
	 
	 @PostMapping("/show-user-form-ret")
	 public String showUserFormRet(@ModelAttribute CreateForm form) {
		 return "create_user";
	 }
	 
	 /*新規登録リクエスト（登録画面から確認へ）*/
	  @PostMapping("/create-user")
	  public String createUser(@ModelAttribute CreateForm form) {
		 
		  return "confirm_create_user";
	  }
	 
	 /*新規登録リクエスト（確認画面から完了）*/
	  @PostMapping("/confirm-create-user")
	  public String confirmCreateUser(@ModelAttribute CreateForm form, Model model) {
		  model.addAttribute("msg", "新規社員登録が完了しました。");
		  return "complete_create_user";
	  }
	 
}
