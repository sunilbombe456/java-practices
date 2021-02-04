package com.webwork.aopdemo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.webwork.aopdemo.Account;

@Component
public class AccountDao {
	
	private String name;
	
	private String serviceCode;
	 

	public void addAccount(Account theAccount ,boolean status) {
		System.out.println(getClass() + " :Doing my DB Work: ADDING AN ACCOUNT");

	}
	
	public boolean doWork() {
		
		System.out.println(getClass() + ": DOING WORK");
		return false;
		
		
	}

	public String getName() {
		System.out.println(getClass() + ": in getName()");
		return name;
	}

	public void setName(String name) {
		System.out.println(getClass() + ": in setName()");
		this.name = name;
	}

	public String getServiceCode() {
		System.out.println(getClass() + ": in getServiceCode()");
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		System.out.println(getClass() + ": in setServiceCode()");
		this.serviceCode = serviceCode;
	}
	
	
	public List<Account> findAccounts(boolean tripWire) {
		
		if(tripWire) {
			throw new RuntimeException("No Sup for You...!!!");
		}
		
		List<Account> accountList = new ArrayList<>();
		
		Account temp1 = new Account("ganesh","rahul");
		Account temp2 = new Account("sahil", "dabhade");
		Account temp3 = new Account("Ganesha","Shiva");
		
		accountList.add(temp1);
		accountList.add(temp2);
		accountList.add(temp3);
		
		return accountList;
	}

	
}
