package com.webwork.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.webwork.hibernate.demo.entity.Course;
import com.webwork.hibernate.demo.entity.Instructor;
import com.webwork.hibernate.demo.entity.InstructorDetail;
import com.webwork.hibernate.demo.entity.Review;
import com.webwork.hibernate.demo.entity.Student;

public class CreateCourseAndStudentdemo {

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

			// Create a New Course

			Course tempCourse = new Course("Pacman -how to score one millian");

			// save the Course
			session.save(tempCourse);
			
			// Create a new Student
			Student student1 =new Student("rahul", "narhe", "rahulnarhe@gmail.com");
			
			Student student2 =new Student("ganesh", "bombe", "ganeshbombe@gmail.com");
			
			Student student3 =new Student("sahil", "dabhade", "sahildabhade@gmail.com");
			
			Student student4 =new Student("kiran", "bombe", "kiranbombe@gmail.com");
				
			// Add Student to the Course

			tempCourse.addStudent(student1);
			
			tempCourse.addStudent(student2);
			
			tempCourse.addStudent(student3);
			
			tempCourse.addStudent(student4);
			
			//save the Student into database 
			
			session.save(student1);
			
			session.save(student2);
			
			session.save(student3);
			
			session.save(student4);
			
			// Adding new Course Review

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
