package com.webwork.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SetterDemoApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		load config file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
//		retrive beans 
		CricketCoach cricketCoach = context.getBean("myCricketCoach", CricketCoach.class);
//		use method from beans
		System.out.println(cricketCoach.getDailyWorkout());
		System.out.println(cricketCoach.getDailyFortune());

		System.out.println(cricketCoach.getEmailAddress());

		System.out.println(cricketCoach.getTeam());
//		close config file

	}

}
