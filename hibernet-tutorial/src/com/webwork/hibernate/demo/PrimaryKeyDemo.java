package com.webwork.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.webwork.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Create A Session Factory 
	 SessionFactory factory = new Configuration()
			 .configure("hibernate.cfg.xml")
			 .addAnnotatedClass(Student.class)
			 .buildSessionFactory();
	 
	 //Create A Session
	 
	 Session session = factory.getCurrentSession();
	 
	 try {
		 //Create 3 Student Object 
		 System.out.println("Create a Three Student Object");
		 Student tempStudent1 = new Student("ganesh","bombe",null,"ganeshbombe@gmail.com");
		 Student tempStudent2 = new Student("sahil","bombe",null,"sahilbombe@gmail.com");
		 Student tempStudent3 = new Student("ramesh","bombe",null,"rameshbombe@gmail.com");
		 
		 //Start Transaction 
		 session.beginTransaction();
		 
		 //Save the Student Object
		 session.save(tempStudent1);
		 session.save(tempStudent2);
		 session.save(tempStudent3);
		 //Commit The Transaction
		 
		 session.getTransaction().commit();
		 
	 }finally {
		 factory.close();
	 }
	 
	
	 
	 //
	}
	

}
