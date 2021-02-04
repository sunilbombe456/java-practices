package com.webwork.builderpattern.services.impl;

import com.webwork.builderpattern.services.AirplaneBuilder;

public class Airliner extends AirplaneBuilder {

	public Airliner(String customer) {
		super.customer = customer;
		super.type = "787 Dreamliner";
	}

	@Override
	public void buildWings() {
		// TODO Auto-generated method stub
		airplane.setWingspan(197f);

	}

	@Override
	public void buildPowerplant() {
		// TODO Auto-generated method stub
		airplane.setPowerplant("dual turbofan");

	}

	@Override
	public void buildAvionics() {
		// TODO Auto-generated method stub
		airplane.setAvionics("commercial");
	}

	@Override
	public void buildSeats() {
		// TODO Auto-generated method stub
		airplane.setNumberSeats(8, 289);

	}

}
