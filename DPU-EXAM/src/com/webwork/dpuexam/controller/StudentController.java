package com.webwork.dpuexam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.webwork.dpuexam.model.StudentModel;
import com.webwork.dpuexam.service.StudentService;


@Controller
@RequestMapping("/Student")
public class StudentController {
	
	@Autowired
	private StudentService studentService;

	@GetMapping("/LoginForm")
	public String studentLoginForm(Model theModel) {

		theModel.addAttribute("student", new StudentModel());
		
		return "student-login-form";
		
	}
	
	@GetMapping("/SaveStudent")
	public String saveStudent() {
		
		studentService.saveStudent();
		
		return "student";
	}
	

}
