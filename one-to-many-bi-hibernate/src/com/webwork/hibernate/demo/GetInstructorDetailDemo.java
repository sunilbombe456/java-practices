package com.webwork.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.webwork.hibernate.demo.entity.Instructor;
import com.webwork.hibernate.demo.entity.InstructorDetail;

public class GetInstructorDetailDemo {

	public static void main(String[] args) {

		// Create Session Factory

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).buildSessionFactory();

		// Create Session Object
		Session session = factory.getCurrentSession();

		try {
			// Instructor Details Id

			int theId = 0;

			session.beginTransaction();

			InstructorDetail tempInstructorDetail = session.get(InstructorDetail.class, theId);

			System.out.println("\n\n found Instructor Details \n" + tempInstructorDetail);
			if (null != tempInstructorDetail) {
				System.out.println("\n\n found Instructor  \n" + tempInstructorDetail.getInstructor());
			}

			session.getTransaction().commit();
		} catch (Exception e) {
			// Handle null Issue
			e.printStackTrace();
		} finally {
			// Handle Connection Leak Issues

			session.close();
			factory.close();
		}

	}

}
