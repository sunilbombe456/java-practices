package com.webwork.springsecurity.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {

	@GetMapping("/")
	public String showHome() {
		return "home";
	}
	
	// add request for mapping request /leaders

	@GetMapping("/leaders")
	public String showLeaders() {
		return"leader";
	}
	
	@GetMapping("/systems")
	public String showSystem() {
		return "system";
	}
}
