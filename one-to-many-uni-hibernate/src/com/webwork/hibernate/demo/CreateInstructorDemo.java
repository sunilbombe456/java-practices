package com.webwork.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.webwork.hibernate.demo.entity.Course;
import com.webwork.hibernate.demo.entity.Instructor;
import com.webwork.hibernate.demo.entity.InstructorDetail;

public class CreateInstructorDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Create Session Factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.buildSessionFactory();

		// Create A Session
		Session session = factory.getCurrentSession();

		try {
			// use the Session object to save the java Object

			// Create a Student Object
			System.out.println("Creating a new Instructor Object Object..!");
			
			Instructor theInstructor = new Instructor("sunil","bombe","sunilbombe@gmail.com");

			InstructorDetail theInstructorDetail = new InstructorDetail("http:www.youtube.com/suinilbombe1998","Cricket");
			
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
			session.close();
			factory.close();
		}
	}

}
