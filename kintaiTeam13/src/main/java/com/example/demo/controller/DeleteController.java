package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.form.StampForm;
import com.example.demo.service.DeleteService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class DeleteController {
	
	@Autowired
    private final DeleteService deleteService;

	
	@PostMapping("/delete")
	public String deleteWork(@ModelAttribute StampForm form) {
	
		return "stamp_delete";
	}
	
	@PostMapping("/delete_result")
	public String delete(@ModelAttribute StampForm form) {
	System.out.println(form);	 
	
		
		deleteService.delete(form.getRegistId());
		
		
		return "delete_result";
	}
}
