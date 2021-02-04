package com.webwork.observer;

import com.webwork.observer.interfaces.AlarmListener;
import com.webwork.observer.interfaces.impl.Gates;
import com.webwork.observer.interfaces.impl.Lighting;
import com.webwork.observer.interfaces.impl.Surveillance;

public class ObserverDemo {

	public static void main(String[] args) {
		SensorSystem sensorSystem = new SensorSystem();
		
		AlarmListener gate = new Gates();
		
		AlarmListener light = new Lighting();
		
		AlarmListener surveillance = new Surveillance();
		
		
		sensorSystem.register(gate);
		
		sensorSystem.register(light);
		
		sensorSystem.register(surveillance);
		
		sensorSystem.soundTheAlarm();

	}

}
