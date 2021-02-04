package com.webwork.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpringDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// creating context object
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		// get beans

		Coach theCoach = context.getBean("myCoach", Coach.class);

//		calling function from dependency 
		System.out.println(theCoach.getDailyWorkout());

		System.out.println(theCoach.getDailyFortune());

//		close the context
		context.close();

	}

}
