package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Student;

@RestController
@RequestMapping("/api")
public class DemoController {

	// Inject properties for Coach Name and Team Name
	@Value("${coach.name}")
	private String coachName;
	
	@Value("${team.name}")
	private String teamName;
	
	//expose the new EndPoints
	
	@GetMapping("/teaminfo")
	public String getTeamInfo() {
		return "Coach Name: "+ coachName +" Team Name :"+ teamName; 
	}
	
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
