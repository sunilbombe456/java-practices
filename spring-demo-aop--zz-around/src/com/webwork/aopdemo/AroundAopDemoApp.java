package com.webwork.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.webwork.aopdemo.service.TrafficFortuneService;

public class AroundAopDemoApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// read the Spring config java Class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

		// get the bean from spring config
		TrafficFortuneService theFortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);

		System.out.println("\n Main Program AroundDemoApp");

		System.out.println("calling GetFortune");

		String data = theFortuneService.getFortune();

		System.out.println("My Fortune is : " + data);

		context.close();
	}

}
