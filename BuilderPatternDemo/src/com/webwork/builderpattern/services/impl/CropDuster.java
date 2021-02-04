package com.webwork.builderpattern.services.impl;

import com.webwork.builderpattern.services.AirplaneBuilder;

public class CropDuster extends AirplaneBuilder {

	public CropDuster(String customer) {
		super.customer = customer;
		super.type = "Crop Duster v3.4";
	}

	@Override
	public void buildWings() {
		// TODO Auto-generated method stub
		airplane.setWingspan(9f);

	}

	@Override
	public void buildPowerplant() {
		// TODO Auto-generated method stub
		airplane.setPowerplant("single piston");

	}

	@Override
	public void buildAvionics() {
		// TODO Auto-generated method stub

	}

	@Override
	public void buildSeats() {
		// TODO Auto-generated method stub
		airplane.setNumberSeats(1, 1);

	}

}
