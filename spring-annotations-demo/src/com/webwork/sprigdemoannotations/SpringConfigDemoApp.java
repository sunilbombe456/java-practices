package com.webwork.sprigdemoannotations;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringConfigDemoApp {

	public static void main(String[] args) {
		
		
		// TODO Auto-generated method stub
//		load Spring Config file herre
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
//		Retrive bean from Context\
		
//		Coach theCoach = context.getBean("tenniesCoach", Coach.class);
		
	Coach theCoach = context.getBean("swimCoach",Coach.class);	
	
	
		System.out.println(theCoach.getDailyWorkout());
		
		System.out.println(theCoach.getDailyFortune());
		
//		close context
		
		context.close();


	}

}
