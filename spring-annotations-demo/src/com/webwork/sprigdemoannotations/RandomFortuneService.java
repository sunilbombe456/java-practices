package com.webwork.sprigdemoannotations;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class RandomFortuneService implements FortuneService {
	private String[] data = {"beware of the wolf in sheep's clothing",
			"deligence is the mother of good luck",
			"the journey is the Reward"};
	Random random = new Random();
	@Override
	public String getFortune() {
		// TODO Auto-generated method stub
		int index = random.nextInt(data.length);
		return data[index];
	}

}
