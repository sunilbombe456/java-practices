package com.webwork.onlineexam.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.webwork.onlineexam.model.StudentModel;
import com.webwork.onlineexam.service.StudentService;


@Controller
@RequestMapping("/Student")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}
	

	@RequestMapping("/LoginForm")
	public String studentLogin(Model theModel) {
		theModel.addAttribute("student", new StudentModel());
		return "student-login-form";
	}

	@RequestMapping("/Login")
	public String login(@Valid @ModelAttribute("student") StudentModel theStudent, BindingResult theBindingResult) {

		System.out.println("Binding Result:  " + theBindingResult);

		System.out.println("\n\n\n");
		if (theBindingResult.hasErrors()) {
			return "student-login-form";
		} else {
		
			return "student-dash";
		}

	}
}
