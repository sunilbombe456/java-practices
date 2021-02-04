package com.webwork.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.webwork.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Create Session Factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// Create A Session
		Session session = factory.getCurrentSession();

		try {

			// Start a Transaction
			session.beginTransaction();

			List<Student> theStudents = session.createQuery("from Student").list();

			// Display the Student List
			displayStudent(theStudents);

			System.out.println("Student Whose First Name is Sunil");
			theStudents = session.createQuery("from Student s where s.firstName='Sunil'").list();

			displayStudent(theStudents);

			// Display First name Last name with the Help of first name And Last Name
			theStudents = session.createQuery("from Student s where s.firstName='Sunil' OR lastName='Bombe'").list();

			System.out.println("\n\n \n Display with the help of First Name and Last Name");
			displayStudent(theStudents);
			
			//display Student with LIKE
			theStudents = session.createQuery("from Student s where"+" s.email LIKE '%gmail.com'").list();
			
			System.out.println("\n\n\n Display Student with the Help of LIKE Query");
			displayStudent(theStudents);
			
			// Commit the Transaction
			session.getTransaction().commit();

			System.out.println("Done..!");
		} finally {
			factory.close();
		}
	}

	private static void displayStudent(List<Student> theStudents) {
		for (Student theStudent : theStudents) {
			System.out.println(theStudent);
		}
	}

}
