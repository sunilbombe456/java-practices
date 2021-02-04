package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Student;

@RestController
@RequestMapping("/api")
public class DemoController {

	@GetMapping("/Student")
	public Student getStudent() {
		Student theStudent = new Student("Sunil", "Bombe");
		return theStudent;
	}
	
	
	@GetMapping("/workout")
	public String getDailyWorkout() {
		return "daily moring work out";
	}


}
