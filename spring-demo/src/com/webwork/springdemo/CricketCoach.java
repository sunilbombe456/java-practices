package com.webwork.springdemo;

public class CricketCoach implements Coach {
	
	private FortuneService fortuneService;
	
	//private field for email address and team
	private	String emailAddress;
	
	private String team;
	
	
	
	
	public String getEmailAddress() {
		return emailAddress;
	}


	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}


	public String getTeam() {
		return team;
	}


	public void setTeam(String team) {
		this.team = team;
	}


	// creating no arg constructor
	public CricketCoach() {
		System.out.println("Cricket Coach with no arg constructor");
	}
	

// our setter method
	public void setFortuneService(FortuneService fortuneService) {
		System.out.println("We are in the Setter method");
		this.fortuneService = fortuneService;
	}


	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "practice fast bollng 15 minutes for a day";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return fortuneService.getFortune();
	}

}
