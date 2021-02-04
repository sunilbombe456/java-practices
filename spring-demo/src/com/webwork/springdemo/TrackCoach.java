package com.webwork.springdemo;

public class TrackCoach implements Coach {

	private FortuneService fortuneService;
	
	
	public TrackCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "run a hard 5k";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return "just o it "+ fortuneService.getFortune();
	}
	
//	ADD AN INIT METHOD
	
	public void doMyStratupStuff() {
		System.out.println("trackCoach inside INIT Method");
	}
	
//	ADD AN DESTROY METHOD
	public void doMyCleanUpStuff() {
		System.out.println("TrackCoach inside DESTROY Method");
	}
}
