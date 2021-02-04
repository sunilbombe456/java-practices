package com.webwork.sprigdemoannotations;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SwimSpringConfigDemoApp2 {

	public static void main(String[] args) {
		
		
		// TODO Auto-generated method stub
//		load Spring Config file herre
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
//		Retrive bean from Context\
		
//		Coach theCoach = context.getBean("tenniesCoach", Coach.class);
		
	BadSwimCoach theCoach = context.getBean("badSwimCoach",BadSwimCoach.class);	
	
	
		System.out.println(theCoach.getDailyWorkout());
		
		System.out.println(theCoach.getDailyFortune());
		
		System.out.println(theCoach.getEmail() + " " + theCoach.getTeam());
		
//		close context
		
		context.close();


	}

}
