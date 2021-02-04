package com.webwork.onlineexam.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class TeacherModel {

	@NotNull(message="is required..!")
	@Pattern(regexp = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$", message = "Email is Not valid..!")
	private String username;
	
	@NotNull(message="is required..!")
	private String password;
	
	private String remember;
	
	

	public TeacherModel() {
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRemember() {
		return remember;
	}

	public void setRemember(String remember) {
		this.remember = remember;
	}
	
	
}
