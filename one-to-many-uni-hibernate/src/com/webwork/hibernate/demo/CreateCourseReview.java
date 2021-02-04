package com.webwork.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.webwork.hibernate.demo.entity.Course;
import com.webwork.hibernate.demo.entity.Instructor;
import com.webwork.hibernate.demo.entity.InstructorDetail;
import com.webwork.hibernate.demo.entity.Review;

public class CreateCourseReview {

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
			int theId = 10;

			// Create a Student Object

			// Start Transaction
			session.beginTransaction();

			Course tempCourse = new Course("Pacman -how to score one millian");
			
			tempCourse.add(new Review("Great Course we Loved it"));
			
			tempCourse.add(new Review("Cool Course, Job well done"));
			
			tempCourse.add(new Review("What a dumb Course , you are an idiot"));
			
			session.save(tempCourse);

			session.getTransaction().commit();

			System.out.println("Done..!");
		} finally {
			session.close();
			factory.close();
		}
	}

}
