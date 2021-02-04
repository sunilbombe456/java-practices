package com.webwork.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.webwork.hibernate.demo.entity.Course;
import com.webwork.hibernate.demo.entity.Instructor;
import com.webwork.hibernate.demo.entity.InstructorDetail;

public class CreateInstructorCourseDemo {

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

			// Create Some Courses

			Course course1 = new Course("MPSC the Ultimate guide");
			Course course2 = new Course("BSc in Computer Science");

			// Add Courses to the Instructor

			instructor.add(course1);
			instructor.add(course2);

			// Save the Courses

			session.save(course1);
			session.save(course2);

		

			// Commit the Transaction
			session.getTransaction().commit();

			System.out.println("Done..!");
		} finally {
			session.close();
			factory.close();
		}
	}

}
