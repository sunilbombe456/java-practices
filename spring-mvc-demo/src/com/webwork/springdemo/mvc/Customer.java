package com.webwork.springdemo.mvc;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.webwork.springdemo.mvc.validation.CourseCode;

public class Customer {

	@NotNull(message="is requird..!")
	@Size(min=1, message="is required..!")
	private String firstName;
	
	private String lastName;
	
	@NotNull(message="is required..!")
	@Min(value=0 , message="Must be Greater than Zero")
	@Max(value=10 , message="Must be Less than Ten")
	private Integer freePasses;
	
	
	@Pattern(regexp="^[a-zA-Z0-9]{5}", message="only Five Chars/Digit..!")
	private String postalCode;
	
	
	@CourseCode
	private String courseCode;
	

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getFreePasses() {
		return freePasses;
	}

	public void setFreePasses(Integer freePasses) {
		this.freePasses = freePasses;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}
	

}
