package com.webwork.sprigdemoannotations;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationBeanScopeApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		load Spring Config file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
//		Retrive Bean Spring From Container
		
		Coach theCoach1 = context.getBean("swimCoach", Coach.class);
		
		Coach theCoach2 = context.getBean("swimCoach", Coach.class);
		
		System.out.println(theCoach1.getDailyWorkout());

		boolean result = (theCoach1 == theCoach2);
		
		System.out.println("both Beans are Same : " + result + " both Memory Location \n"+ theCoach1 + "\n " + theCoach2 );
		
//		close the Spring Container
		context.close();
		
		

	}

	
	

}
