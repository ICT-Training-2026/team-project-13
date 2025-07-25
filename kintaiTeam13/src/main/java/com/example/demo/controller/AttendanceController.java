package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.entity.Attendance;
import com.example.demo.form.AttendanceForm;
import com.example.demo.service.AttendanceService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class AttendanceController {
	
	private final AttendanceService service;

	@PostMapping("/stamp_regist")
	public String showRegistForm(@ModelAttribute AttendanceForm form,
			@RequestParam(required = true) String id,
			Model model) {
		
		//model.addAttribute("id", id);
		form.setEmployeeId(id);

		
		System.out.println(model);
		
		return "stamp_regist";
	}
	
//	@PostMapping("/stamp_regist_ret")
//	public String showRegistFormRet(@ModelAttribute AttendanceForm form,
//			@RequestParam String id, 
//			Model model) {
//		return "stamp_regist";
//	}

	@PostMapping("/confirm_regist")
	public String submitAttendance(@Validated @ModelAttribute AttendanceForm form,
			@RequestParam(required = false) String id,
			Model model,
			BindingResult result,
			RedirectAttributes redirectAttributes) {
		
		form.setEmployeeId(id);
		System.out.println(model);

		if (result.hasErrors()) {
			return "stamp_regist";
		}
		return "confirm_regist";
	}

	@PostMapping("/complete")
	public String registAttendance(@Validated AttendanceForm form,
			@RequestParam(required = false) String id,
			Model model,
			BindingResult result,
			RedirectAttributes redirectAttributes) {
		
//		form.setEmployeeId(id);
		System.out.println(model);

		if (result.hasErrors()) {
			return "stamp_regist";
		}

		Attendance at = new Attendance();
		at.setEmployeeId(form.getEmployeeId());
		at.setStatusId(form.getStatusId());
		at.setWorkDate(form.getWorkDate());
		at.setStartTime(form.getStartTime());
		at.setEndTime(form.getEndTime());
		at.setBreakTime(form.getBreakTime());
		at.setComments(form.getComments());
		service.regist(at);

		redirectAttributes.addFlashAttribute("msg", "(勤怠登録)");

		return "/complete";
	}
	
	@PostMapping("/top_from_register")
	public String returnTop(@ModelAttribute AttendanceForm form,
			@RequestParam(required = false) String id,
			Model model) {
		
		return "top";
	}
}
