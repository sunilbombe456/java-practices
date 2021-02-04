package com.webwork.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.webwork.hibernate.demo.entity.Course;
import com.webwork.hibernate.demo.entity.Instructor;
import com.webwork.hibernate.demo.entity.InstructorDetail;

public class EagerVsLazyDemo {

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
			// Get the Instructor from database
			int theId = 1;

			// Get Instructor

			Instructor instructor = session.get(Instructor.class, theId);

			System.out.println("\n\n WebWork  Instructor" + instructor);

			System.out.println("\n\n WebWork Courses From Instructor" + instructor.getCourse());
			

			// Commit the Transaction
			session.getTransaction().commit();
			
			session.close();

			System.out.println("\n\n WebWork Courses From Instructor" + instructor.getCourse());
			
			System.out.println("Done..!");
		} finally {
//			session.close();
			factory.close();
		}
	}

}
