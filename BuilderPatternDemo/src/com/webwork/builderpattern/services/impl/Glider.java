package com.webwork.builderpattern.services.impl;

import com.webwork.builderpattern.services.AirplaneBuilder;

public class Glider extends AirplaneBuilder {


	public Glider(String customer){
		super.customer = customer;
		super.type = "Glider v9.0";
	}

	
	@Override
	public void buildWings() {
		// TODO Auto-generated method stub
		airplane.setWingspan(57.1f);

	}

	@Override
	public void buildPowerplant() {
		// TODO Auto-generated method stub

	}

	@Override
	public void buildAvionics() {
		// TODO Auto-generated method stub

	}

	@Override
	public void buildSeats() {
		// TODO Auto-generated method stub
		airplane.setNumberSeats(1,0);
	}

}
