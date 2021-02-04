package com.webwork.sprigdemoannotations;

import org.springframework.beans.factory.annotation.Value;

public class BadSwimCoach implements Coach {
	
	private FortuneService fortuneService;
	
	public BadSwimCoach(FortuneService theFortuneService) {
		fortuneService = theFortuneService;
	}
	@Value("${foo.email}")
	private String email;
	
	@Value("${foo.team}")
	private String team;

	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "Swim 1000 meter as a Warm up";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return fortuneService.getFortune();
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getTeam() {
		return team;
	}

}
