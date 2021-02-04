package com.webwork.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.webwork.hibernate.demo.entity.Course;
import com.webwork.hibernate.demo.entity.Instructor;
import com.webwork.hibernate.demo.entity.InstructorDetail;
import com.webwork.hibernate.demo.entity.Review;
import com.webwork.hibernate.demo.entity.Student;

public class AddCoursesForMaryDemo {

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
			// getting the student mary from database
			int theId = 4;
			
			Student tempStudent = session.get(Student.class, theId);
			 System.out.println("\n\n\n loaded Student "+ tempStudent);
			 System.out.println("\n\nCourses "+ tempStudent.getCourse());
			 
			// create more Courses
			Course tempCourse1 = new Course("To Solve Rubic Cube");
			Course tempCourse2 = new Course("playing Gitar");
			Course tempCourse3 = new Course("Advanced Java Programming");
			
			
			// Add Courses to the Student
			
			tempStudent.addCourse(tempCourse1);
			tempStudent.addCourse(tempCourse2);
			tempStudent.addCourse(tempCourse3);
			
		
			//Save the Courses
			System.out.println("\n Saving the Courses..!");
			session.save(tempCourse1);
			session.save(tempCourse2);
			session.save(tempCourse3);

			session.getTransaction().commit();

			System.out.println("Done..!");
		} finally {
			session.close();
			factory.close();
		}
	}

}
