package com.webwork.sprigdemoannotations;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
//@PropertySource("classpath:sport.properties")
public class SwimCoach implements Coach {
	@Autowired
	@Qualifier("fortuneServiceImpl")
	private FortuneService fortuneService;

	@Value("${foo.email}")
	private String email;

	@Value("${foo.team}")
	private String team;
	
	@PostConstruct
	public void doMyStartUpStuff() {
		System.out.println("SwimCoach >> Inside doMyStartUpStuff");
	}
	
	@PreDestroy
	public void doMyCleanUpStuff() {
		System.out.println("SwimCoach >> Inside doMyCleanUpStuff");
	}

	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "Daily Workout with " + team + " " + email;
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return fortuneService.getFortune();
	}

}
