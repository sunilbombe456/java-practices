package com.webwork.builderpattern;

import com.webwork.builderpattern.dto.Airplane;
import com.webwork.builderpattern.services.AirplaneBuilder;
import com.webwork.builderpattern.services.impl.Airliner;
import com.webwork.builderpattern.services.impl.CropDuster;
import com.webwork.builderpattern.services.impl.FighterJet;
import com.webwork.builderpattern.services.impl.Glider;

public class BulderPatternDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// instantiate the director (hire the engineer)
				AerospaceEngineer aero = new AerospaceEngineer();
				
				// instantiate each concrete builder (take orders)
				AirplaneBuilder crop = new CropDuster("Farmer Joe");
				AirplaneBuilder fighter = new FighterJet("The Navy");
				AirplaneBuilder glider = new Glider("Tim Rice");
				AirplaneBuilder airliner = new Airliner("United Airlines");
				
				// build a CropDuster
				aero.setAirplaneBuilder(fighter);
				aero.constructAirplane();
				Airplane completedCropDuster = aero.getAirplane();
				System.out.println(completedCropDuster.getType() +
						" is completed and ready for delivery to " +
						completedCropDuster.getCustomer());
				
				System.out.println("\n Features of airoplane: \n" + completedCropDuster);



	}

}
