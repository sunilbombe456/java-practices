package com.webwork.springbootlogger.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
	
	Logger logger = LoggerFactory.getLogger(DemoController.class);
	
	@GetMapping("hello")
	public String sayHello() {
		logger.trace("Home Method is Accessed...!");
		return "Hello WOrd";
	}

}
