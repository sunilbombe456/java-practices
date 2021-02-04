package com.webwork.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJavaJdbc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String jdbcUrl = "jdbc:mysql://localhost:3308/hb_student_tracker?useSSL=false";
		String user = "hbstudent";
		String password = "hbstudent";
		try {
			System.out.println("Connecting to Database " + jdbcUrl);
			
			Connection connection = DriverManager.getConnection(jdbcUrl, user, password);
			
			if(null!= connection) {
				System.out.println("Connection is Succesfull..!");
			}else {
				System.out.println("Connection is Not Succesfull ...!");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
