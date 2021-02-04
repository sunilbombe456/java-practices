package com.webwork.springdemo.mvc;

import java.util.LinkedHashMap;

public class Student {

	private String firstName;

	private String lastName;

	private String country;

	private LinkedHashMap<String, String> countryOptions;

	private String favouriteLanguage;

	private String[] operatingSystems;

	public Student() {

//		populate Country LinkedHashMap
		countryOptions = new LinkedHashMap<>();
		countryOptions.put("In", "India");
		countryOptions.put("Fr", "France");
		countryOptions.put("Gr", "Germany");
		countryOptions.put("Br", "Brazil");
		countryOptions.put("Ch", "China");

	}

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

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public LinkedHashMap<String, String> getCountryOptions() {
		return countryOptions;
	}

	public String getFavouriteLanguage() {
		return favouriteLanguage;
	}

	public void setFavouriteLanguage(String favouriteLanguage) {
		this.favouriteLanguage = favouriteLanguage;
	}

	public String[] getOperatingSystems() {
		return operatingSystems;
	}

	public void setOperatingSystems(String[] operatingSystems) {
		this.operatingSystems = operatingSystems;
	}

}
