package com.webwork.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.webwork.aopdemo.dao.AccountDao;

public class AfterFinallyDemoApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// read the Spring config java Class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

		// get the bean from spring config
		AccountDao accountDao = context.getBean("accountDao", AccountDao.class);

		List<Account> theAccount = null;
		try {
			// add a boolean flag to simulate the exception
			boolean tripWire = false;

			theAccount = accountDao.findAccounts(tripWire);

		} catch (Exception e) {
			System.out.println("\n Main Program catch the Exception:  " + e);
		}

		System.out.println("\n\n Main Program after returning demoApp");
		System.out.println("\n -----\n");
		System.out.println(theAccount);
		System.out.println("\n");
		context.close();
	}

}
