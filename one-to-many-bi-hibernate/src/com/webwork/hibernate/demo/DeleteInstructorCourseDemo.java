package com.webwork.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.webwork.hibernate.demo.entity.Course;
import com.webwork.hibernate.demo.entity.Instructor;
import com.webwork.hibernate.demo.entity.InstructorDetail;

public class DeleteInstructorCourseDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Create Session Factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).buildSessionFactory();

		// Create A Session
		Session session = factory.getCurrentSession();

		try {
			// Start a Transaction
			session.beginTransaction();
			
			// Get the Course From Database		
			int theId = 10;
			
			Course theCourse = session.get(Course.class, theId);

			//Delete The Course 
			session.delete(theCourse);
			
			// Commit the Transaction
			session.getTransaction().commit();

			System.out.println("Done..!");
		} finally {
			session.close();
			factory.close();
		}
	}

}
