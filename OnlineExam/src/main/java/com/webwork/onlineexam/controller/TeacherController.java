package com.webwork.onlineexam.controller;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.webwork.onlineexam.model.TeacherModel;

@Controller
@RequestMapping("/Teacher")
public class TeacherController {
	
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}

	@RequestMapping("/LoginForm")
	public String teacherLogin(Model model) {
		model.addAttribute("teacher", new TeacherModel());
		return "teacher-login-form";
	}

	@RequestMapping("/Login")
	public String login(@Valid @ModelAttribute("teacher") TeacherModel theTeacher, BindingResult theBindingResult) {

		System.out.println("Binding Result:  " + theBindingResult);

		System.out.println("\n\n\n");
		if (theBindingResult.hasErrors()) {
			return "teacher-login-form";
		} else {
			return "teacher-dash";
		}

	}

}
