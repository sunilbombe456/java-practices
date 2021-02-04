package com.webwork.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.webwork.aopdemo.dao.AccountDao;
import com.webwork.aopdemo.dao.MembershipDAO;

public class MainDempApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// read the Spring config java Class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

		// get the bean from spring config
		AccountDao accountDao = context.getBean("accountDao", AccountDao.class);

		// call the business method
		Account myAccount = new Account();
		
		accountDao.addAccount(myAccount);
		
		accountDao.doWork();
		
		
		//get membership bean from spring container
		
		MembershipDAO membershipDAO = context.getBean("membershipDAO", MembershipDAO.class);
		
		//LETS CALL ADD ACCOUNT METHOD FROM MEMBERSHIP DAO
		
		System.out.println("\n\n Calling Memebership DAO method ");
		membershipDAO.addSillyMember();
		
		//close the context\
		context.close();
	}

}
