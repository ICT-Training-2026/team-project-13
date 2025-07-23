package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.User;
import com.example.demo.form.CreateForm;
import com.example.demo.service.CreateService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class CreateController {
	
	private final CreateService service;
  
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
	  public String createUser(@Validated @ModelAttribute CreateForm form,
			  BindingResult result) {
		 
		  if (result.hasErrors()) {
			  return "create_user";
		  }
		  return "confirm_create_user";
	  }
	 
	 /*新規登録リクエスト（確認画面から完了）*/
	  @PostMapping("/confirm-create-user")
	  public String confirmCreateUser(@Validated /*@ModelAttribute*/ CreateForm form, 
			  BindingResult result, Model model) {
		  
		  if (result.hasErrors()) {
			  return "create_user";
		  }
		  
		  User u = new User();
		  u.setEmployeeId(form.getEmployeeId());
		  u.setName(form.getName());
		  u.setDepartmentId(form.getDepartmentId());
		  u.setPass(form.getPass());
		  u.setAuthority(form.getAuthority());
		  service.create(u);
				  
		  
		  model.addAttribute("msg", "新規社員登録が完了しました。");
		  return "complete_create_user";
	  }
}

