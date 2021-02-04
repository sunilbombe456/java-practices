package com.webwork.sprigdemoannotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class TenniesCoach implements Coach {
//	private FortuneService fortuneService;

//	Inject Dependency Directly On the Filed

	@Autowired
	@Qualifier("randomFortuneService")
	private FortuneService fortuneService;

	// define default constructor
	public TenniesCoach() {

		System.out.println("TenniesCoach :Inside Default Constructor");

	}

//	 Inject dependency using Setter Method
//	 @Autowired
//	 public void setFortuneService(FortuneService fortuneService) {
//		 this.fortuneService = fortuneService;
//	 }
//	
	/*
	 * // inject dependency using constructor
	 * 
	 * @Autowired public TenniesCoach(FortuneService fortuneService) {
	 * this.fortuneService = fortuneService; }
	 */
	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "practice your backhand holly";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return fortuneService.getFortune();
	}

}
