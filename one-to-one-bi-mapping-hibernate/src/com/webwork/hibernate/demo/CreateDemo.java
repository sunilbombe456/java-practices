package com.webwork.hibernate.demo;

import java.text.ParseException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.webwork.hibernate.demo.entity.Instructor;
import com.webwork.hibernate.demo.entity.InstructorDetail;
import com.webwork.hibernate.demo.entity.Student;

public class CreateDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Create Session Factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();

		// Create A Session
		Session session = factory.getCurrentSession();

		try {
			// use the Session object to save the java Object

			// Create a Student Object
			System.out.println("Creating a new Instructor Object Object..!");

		/*	Instructor theInstructor = new Instructor("Sunil","Sakharam","sunilbombe@gmail.com");

			InstructorDetail theInstructorDetail = new InstructorDetail("http:www.youtube.com/sunilBombe1998","Cricket");
			*/
			
			Instructor theInstructor = new Instructor("ganesh","bombe","ganeshbombe@gmail.com");

			InstructorDetail theInstructorDetail = new InstructorDetail("http:www.youtube.com/ganeshbombe1998","Coding");

			theInstructor.setInstructorDetail(theInstructorDetail);

			// Start a Transaction
			session.beginTransaction();

			// Save the Student Object
			System.out.println("Saving the Student..!");
			
			//NOTE : This will also save the Object Because of Cascade 
			session.save(theInstructor);

			// Commit the Transaction
			session.getTransaction().commit();

			System.out.println("Done..!");
		} finally {
			factory.close();
		}
	}

}
