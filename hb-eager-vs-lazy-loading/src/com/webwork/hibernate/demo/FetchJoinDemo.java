package com.webwork.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.webwork.hibernate.demo.entity.Course;
import com.webwork.hibernate.demo.entity.Instructor;
import com.webwork.hibernate.demo.entity.InstructorDetail;

public class FetchJoinDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Create Session Factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).buildSessionFactory();

		// Create A Session

		// Option 2 Hibernate Query with HQL

		Session session = factory.getCurrentSession();

		try {
			// Start a Transaction
			session.beginTransaction();
			// Get the Instructor from database
			int theId = 1;

			// Get Instructor
			Query<Instructor> query = session.createQuery(
					"select i from Instructor i " + "JOIN FETCH i.course " + "where i.id=:theInstructorId ",
					Instructor.class);
			
			//Set the Parameter to the Query
			
			query.setParameter("theInstructorId", theId);
			
			//Execute Query and get Instructor
			
			Instructor instructor = query.getSingleResult();

			System.out.println("\n\n WebWork  Instructor" + instructor);

			System.out.println("\n\n WebWork Courses From Instructor" + instructor.getCourse());

			// Commit the Transaction
			session.getTransaction().commit();

			session.close();

			System.out.println("\n\n WebWork Courses From Instructor" + instructor.getCourse());

			System.out.println("Done..!");
		} finally {
//			session.close();
			factory.close();
		}
	}

}
