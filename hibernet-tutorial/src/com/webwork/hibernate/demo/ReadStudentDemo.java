package com.webwork.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.webwork.hibernate.demo.entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Create Session Factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// Create A Session
		Session session = factory.getCurrentSession();

		try {
			// use the Session object to save the java Object

			// Create a Student Object
			System.out.println("Creating a new Student Object..!");
			Student tempStudent = new Student("Sunil", "Bombe",null, "sunilbombe@gmail.com");

			// Start a Transaction
			session.beginTransaction();

			// Save the Student Object
			System.out.println("Saving the Student..!");
			System.out.println(tempStudent);
			session.save(tempStudent);

			// Commit the Transaction
			session.getTransaction().commit();

			
			//MY NEW CODE
			
			//find out Student id Primary key
			System.out.println("Saved Student Generated Id "+ tempStudent.getId());
			
			// now get a new Session to start transaction 
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			//Retrive Student based on ID Primary key
			System.out.println("Getting Student With Id "+ tempStudent.getId());
			
			Student theStudent = session.get(Student.class, tempStudent.getId());
			System.out.println("GET Complete" + theStudent);
			//Commit the Transaction
			session.getTransaction().commit();
			
			System.out.println("Done..!");
			
		} finally {
			factory.close();
		}
	}

}
