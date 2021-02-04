package com.webwork.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.webwork.hibernate.demo.entity.Course;
import com.webwork.hibernate.demo.entity.Instructor;
import com.webwork.hibernate.demo.entity.InstructorDetail;
import com.webwork.hibernate.demo.entity.Review;
import com.webwork.hibernate.demo.entity.Student;

public class DeletePacmanCourseDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Create Session Factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class).addAnnotatedClass(Student.class).buildSessionFactory();

		// Create A Session
		Session session = factory.getCurrentSession();

		try {

			// start transaction
			session.beginTransaction();
			// get the Pacmain Course from database
			int courseId = 10;
			
			Course theCourse = session.get(Course.class, courseId);
			
			
			//Deleting the Course
			
			session.delete(theCourse);
	
			session.getTransaction().commit();

			System.out.println("Done..!");
		} finally {
			session.close();
			factory.close();
		}
	}

}
