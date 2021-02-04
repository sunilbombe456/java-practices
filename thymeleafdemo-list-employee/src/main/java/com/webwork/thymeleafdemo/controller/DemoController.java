package com.webwork.thymeleafdemo.controller;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {

Logger logger = LoggerFactory.getLogger(DemoController.class);
	
	@GetMapping("/hello")
	public String sayHello(Model theModel) {
		theModel.addAttribute("theDate", new Date());
		logger.trace("Home method is accessed..!");
		
		return "helloword";
		
		
	}
}
