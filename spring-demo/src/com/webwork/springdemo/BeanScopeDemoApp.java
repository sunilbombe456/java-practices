package com.webwork.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemoApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		load bean config file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanScope-ApplicationContext.xml");

//		 retrive beans from context

		Coach myCoach = context.getBean("myCoach", Coach.class);
		
		Coach alphaCoach =  context.getBean("myCoach", Coach.class);
//		check if they are the same
		boolean result = (myCoach == alphaCoach);
		
//		print out the results
		System.out.println("pointing to the same object  " + result);
		
//		printing out the memory location of 
		System.out.println("printing out the memory location of myCoach "+ myCoach);
		
		System.out.println("printing out the memory location of alphaCoach "+ alphaCoach);
//		close config
		context.close();
	}

}
