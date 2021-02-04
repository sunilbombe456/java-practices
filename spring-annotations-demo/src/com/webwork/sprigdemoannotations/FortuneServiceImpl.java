package com.webwork.sprigdemoannotations;

import org.springframework.stereotype.Component;

@Component
public class FortuneServiceImpl implements FortuneService {

	@Override
	public String getFortune() {
		// TODO Auto-generated method stub
		return "today is your Lucky day";
	}

}
