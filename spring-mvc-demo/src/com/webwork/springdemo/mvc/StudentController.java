package com.webwork.springdemo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController {

	@RequestMapping("/showForm")
	public String showForm(Model theModel) {

//		create a new Student Object
		Student theStudent = new Student();

//		Add Student object into model
		theModel.addAttribute("student", theStudent);

		return "student-form";
	}

	@RequestMapping("/processForm")
	public String processForm(@ModelAttribute("student") Student theStudent) {
//		log the input Data 
		System.out.println("the Student Name In Log" + theStudent.getFirstName() + " " + theStudent.getLastName());
		return "student-confirmation";
	}

}
