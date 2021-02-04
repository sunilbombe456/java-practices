package com.webwork.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		loading config file into Spring Container
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"beanLifeCycle-applicationContext.xml");

//		Retrive Beans From Spring Config file
		Coach theCoach = context.getBean("myCoach", Coach.class);
		
//		retrive functions from beans IOC
	System.out.println(theCoach.getDailyWorkout());
		
		
//		Close the Context
		context.close();

	}

}
