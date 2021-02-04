package com.webwork.builderpattern.services.impl;

import com.webwork.builderpattern.services.AirplaneBuilder;

public class FighterJet extends AirplaneBuilder {

	public FighterJet(String customer) {
		super.customer = customer;
		super.type = "F-35 Lightning II";
	}

	@Override
	public void buildWings() {
		// TODO Auto-generated method stub
		airplane.setWingspan(35.0f);

	}

	@Override
	public void buildPowerplant() {
		// TODO Auto-generated method stub
		airplane.setPowerplant("dual thrust vectoring");

	}

	@Override
	public void buildAvionics() {
		// TODO Auto-generated method stub
		airplane.setAvionics("military");
	}

	@Override
	public void buildSeats() {
		// TODO Auto-generated method stub
		airplane.setNumberSeats(1, 0);

	}

}
