package com.webwork.testdb;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/testdb")
public class TestDatabase extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) {

		String url = "jdbc:mysql://localhost:3308/web_customer_tracker?useSSL=false";
		String user = "hbstudent";
		String password = "hbstudent";
		
		try {
			Class.forName("org.gjt.mm.mysql.Driver");
			Connection connection = DriverManager.getConnection(url, user, password);
			 if(null == connection) {
				 System.out.println("Connection is not connected");
			 }else {
				 System.out.println("Connection of database is well connected");
			 }
			
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
