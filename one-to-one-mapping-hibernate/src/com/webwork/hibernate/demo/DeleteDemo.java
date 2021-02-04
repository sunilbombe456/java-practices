package com.webwork.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.webwork.hibernate.demo.entity.Instructor;
import com.webwork.hibernate.demo.entity.InstructorDetail;

public class DeleteDemo {

	public static void main(String[] args) {
		
		//Create Session Factory
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		
		
		// Create Session Object
		Session session = factory.getCurrentSession();
		
		try {
			
			int theId = 2;
			
			session.beginTransaction();
			
			Instructor instructor = session.get(Instructor.class, theId);
			
			System.out.println("found Instructor" + instructor);
			
			session.delete(instructor);
			
			session.getTransaction().commit();
		}finally {
			factory.close();
		}
		
		
	}
	
}
