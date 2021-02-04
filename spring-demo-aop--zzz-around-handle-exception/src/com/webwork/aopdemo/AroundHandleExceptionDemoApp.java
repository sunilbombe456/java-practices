package com.webwork.aopdemo;

import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.webwork.aopdemo.service.TrafficFortuneService;

public class AroundHandleExceptionDemoApp {
	
	private static 	Logger myLogger = Logger.getLogger(AroundHandleExceptionDemoApp.class.getName());

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	

		// read the Spring config java Class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

		// get the bean from spring config
		TrafficFortuneService theFortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);

		boolean tripWire = true;
		
		myLogger.info("\n Main Program AroundDemoApp");

		myLogger.info("calling GetFortune");

		String data = theFortuneService.getFortune(tripWire);

		myLogger.info("My Fortune is : " + data);

		context.close();
	}

}
