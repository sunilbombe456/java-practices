package com.webwork.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.webwork.hibernate.demo.entity.Course;
import com.webwork.hibernate.demo.entity.Instructor;
import com.webwork.hibernate.demo.entity.InstructorDetail;
import com.webwork.hibernate.demo.entity.Review;

public class CreateDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Create Session Factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
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
			
			Instructor theInstructor = new Instructor("rahul","narhe","rahulnarhe@gmail.com");
		//	theInstructor.setCourse(null);

			InstructorDetail theInstructorDetail = new InstructorDetail("http:www.youtube.com/rahulnarhe1998","Cricket");

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
