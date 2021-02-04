package com.webwork.onlineexam.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class StudentModel {

	@NotNull(message = "is Required..!")
	@Pattern(regexp = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$", message = "Email is Not valid..!")
	private String userName;

	@NotNull(message = "is Required..!")
	private String userPassword;

	private String remember;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getRemember() {
		return remember;
	}

	public void setRemember(String remember) {
		this.remember = remember;
	}

}
