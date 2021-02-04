package com.webwork.hibernate.demo;

import java.text.ParseException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.webwork.hibernate.demo.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Create Session Factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// Create A Session
		Session session = factory.getCurrentSession();

		try {
			// use the Session object to save the java Object

			  String theDateOfBirthStr = "31/12/1998";
	            Date theDateOfBirth = DateUtils.parseDate(theDateOfBirthStr);
			// Create a Student Object
			System.out.println("Creating a new Student Object..!");
			Student tempStudent = new Student("Sunil", "Bombe",theDateOfBirth, "sunilbombe@gmail.com");

			// Start a Transaction
			session.beginTransaction();

			// Save the Student Object
			System.out.println("Saving the Student..!");
			session.save(tempStudent);

			// Commit the Transaction
			session.getTransaction().commit();

			System.out.println("Done..!");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			factory.close();
		}
	}

}
