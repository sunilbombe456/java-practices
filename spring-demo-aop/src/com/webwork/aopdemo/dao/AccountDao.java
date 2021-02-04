package com.webwork.aopdemo.dao;

import org.springframework.stereotype.Component;

import com.webwork.aopdemo.Account;

@Component
public class AccountDao {

	public void addAccount(Account theAccount) {
		System.out.println(getClass() + " :Doing my DB Work: ADDING AN ACCOUNT");

	}
	
	public boolean doWork() {
		
		System.out.println(getClass() + ": DOING WORK");
		return false;
		
		
	}

}
