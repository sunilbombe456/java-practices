package com.webwork.springdemo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/hello")
public class SillyController {

	@RequestMapping("/showForm")
	public String displayForm() {
		return "silly";
	}
}
