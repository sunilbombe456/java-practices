package com.webwork.jwtauthdemo.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.webwork.jwtauthdemo.entity.AuthRequest;
import com.webwork.jwtauthdemo.util.JwtUtil;

@RestController
public class WelcomeController {

	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private JwtUtil jwtUtil;

	@GetMapping("/")
	public String welcome() {
		return "welcome to JWT TOKEN world";
	}

	@PostMapping("/authenticate")
	public String generateToken(@RequestBody AuthRequest authRequest) throws Exception {
		
		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword()));

		}catch(Exception ex) {
			throw new Exception("invalid username/password");
		}
		
		return jwtUtil.generateToken(authRequest.getUserName());
	}
}
