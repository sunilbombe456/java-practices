package com.webwork.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.webwork.hibernate.demo.entity.Student;

public class UpdateStudentDemo2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Create Session Factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// Create A Session
		Session session = factory.getCurrentSession();

		try {
			int studentId = 1;
			// now get new Session and Start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();

			// Save the Student Object
			Student theStudent = session.get(Student.class, studentId);
			
			theStudent.setFirstName("Omkar");

			// Commit the Transaction
			session.getTransaction().commit();
			
			//uodate Record Using CreateQuery
			
			System.out.println("\n\n\n\nUpdate Record using create Query");
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			session.createQuery("update Student s set s.lastName='Narhe'").executeUpdate();
			
			session.getTransaction().commit();
			
			System.out.println("Done..!");
		} finally {
			factory.close();
		}
	}

}
