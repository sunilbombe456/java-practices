package com.webwork.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.webwork.hibernate.demo.entity.Instructor;
import com.webwork.hibernate.demo.entity.InstructorDetail;

public class DeleteDemo {

	public static void main(String[] args) {

		// Create Session Factory

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).buildSessionFactory();

		// Create Session Object
		Session session = factory.getCurrentSession();

		try {

			int theId = 4;

			session.beginTransaction();

			InstructorDetail instructorDetail = session.get(InstructorDetail.class, theId);
			if (null != instructorDetail) {
				System.out.println("\n\nfound InstructorDetails" + instructorDetail);

				System.out.println("\n\nfound InstructorDetails" + instructorDetail.getInstructor());

				System.out.println("\n\n Deleting instruction Detail using id: " + theId);

				session.delete(instructorDetail);

				session.getTransaction().commit();
			}

		} finally {
			// handle connection leak problem
			session.close();
			factory.close();
		}

	}

}
