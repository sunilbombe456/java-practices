package com.webwork.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {

	public boolean addSillyMember() {
		System.out.println(getClass() + "DOING STUFF:  ADDING MEMBERSHIP ACCOUNT");
		return false;
	}
	
	public void goToSleep() {
		System.out.println(getClass() + "I am Going to sleep");
		
		
	}
}
