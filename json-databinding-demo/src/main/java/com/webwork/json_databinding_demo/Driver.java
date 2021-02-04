package com.webwork.json_databinding_demo;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			// create object mapper
			ObjectMapper mapper = new ObjectMapper();
			// read json file and map/convert to java POGO data-simple-lite.json

			Student theStudent = mapper.readValue(new File("data/sample-full.json"), Student.class);
			// print the firstName And Last name
			System.out.println("\n id: " + theStudent.getId() + "\n First Name: " + theStudent.getFirstName()
					+ "\n Last Name: " + theStudent.getLastName() + "\n Active :" + theStudent.isActive());

			System.out.println("\n Address: " + theStudent.getAddress());
			
			for(String tempLanguage :theStudent.getLanguage()) {
				System.out.println("\n ===> language "+ tempLanguage);
			}

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

}
