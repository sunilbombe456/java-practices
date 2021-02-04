package com.webwork.springdemo.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWordController {
	
	@RequestMapping("/showForm")
	public String showForm() {
		return "helloword-form";
	}
	
	@RequestMapping("/processForm")
	public String processForm() {
		return "helloword";
	}
	
//	create a new Controller two process new Form
	
	@RequestMapping("/processFormVersionTwo")
	public String letsShoutDude(HttpServletRequest request, Model model) {
//		read data from html Form
		String theName = request.getParameter("studentName").toString();
//		convert into Cap
		theName = theName.toUpperCase();
// Create a Message 
		String theResult = "Yo "+ theName;
//		Add data into the model
		model.addAttribute("message", theResult);
		
		return "helloword";
	}
	
	
	@RequestMapping("/processFormVersionThree")
	public String processfromVersionThree(@RequestParam("studentName") String theName, Model model) {
//		convert into Cap
		theName = theName.toUpperCase();
// Create a Message 
		String theResult = "hey Friend From Version Three  "+ theName;
//		Add data into the model
		model.addAttribute("message", theResult);
		
		return "helloword";
	}
}
