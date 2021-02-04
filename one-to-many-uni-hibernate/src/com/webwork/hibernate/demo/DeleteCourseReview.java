package com.webwork.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.webwork.hibernate.demo.entity.Course;
import com.webwork.hibernate.demo.entity.Instructor;
import com.webwork.hibernate.demo.entity.InstructorDetail;
import com.webwork.hibernate.demo.entity.Review;

public class DeleteCourseReview {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Create Session Factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class).buildSessionFactory();

		// Create A Session
		Session session = factory.getCurrentSession();

		try {
			// use the Session object to save the java Object
			int theId = 12;

			// Create a Student Object

			// Start Transaction
			session.beginTransaction();

			Course theCourse = session.get(Course.class, theId);
			
			System.out.println("\n\nThe Course Details "+ theCourse);
			
			System.out.println("\n\n The Reviews "+ theCourse.getReview());
			
			System.out.println("\n\n Deleting the Course");
			
			session.delete(theCourse);
			
			session.getTransaction().commit();

			System.out.println("Done..!");
		} finally {
			session.close();
			factory.close();
		}
	}

}
