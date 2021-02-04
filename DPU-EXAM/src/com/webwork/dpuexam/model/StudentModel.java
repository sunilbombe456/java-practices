package com.webwork.dpuexam.model;

public class StudentModel {
	
	
	private String userName;
	
	private String userPassword;
	
	private String remember;
	
	
	

	public StudentModel() {
	}
	
	

	public StudentModel(String userName, String userPassword, String remember) {
		this.userName = userName;
		this.userPassword = userPassword;
		this.remember = remember;
	}



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



	@Override
	public String toString() {
		return "StudentModel [userName=" + userName + ", userPassword=" + userPassword + ", remember=" + remember + "]";
	}
	
	

}
