package com.webwork.builderpattern;

import com.webwork.builderpattern.dto.Airplane;
import com.webwork.builderpattern.services.AirplaneBuilder;

public class AerospaceEngineer {

	private AirplaneBuilder airplaneBuilder;

	public void setAirplaneBuilder(AirplaneBuilder ab) {
		airplaneBuilder = ab;
	}

	public Airplane getAirplane() {
		return airplaneBuilder.getAirplane();
	}

	public void constructAirplane() {
		airplaneBuilder.createNewAirplane();
		airplaneBuilder.buildWings();
		airplaneBuilder.buildPowerplant();
		airplaneBuilder.buildAvionics();
		airplaneBuilder.buildSeats();
	}
}
