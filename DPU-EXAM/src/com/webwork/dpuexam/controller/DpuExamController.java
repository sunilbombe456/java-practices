package com.webwork.dpuexam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DpuExamController {
	
	@GetMapping("/home")
	public String showHome() {
		return "home";
	}

}
