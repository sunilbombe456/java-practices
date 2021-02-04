package com.webwork.springdemo;

public class BaseballCoach implements Coach {
//	define  private field for dependency
	private FortuneService fortuneService;
// define constructor
	
	BaseballCoach(FortuneService theFortuneService){
		this.fortuneService = theFortuneService;
	}
	@Override
	public String getDailyWorkout() {
		return "spend 30 minutes on batting practice";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		//user my fortune service to get fortune 
		return fortuneService.getFortune();
	}
}
