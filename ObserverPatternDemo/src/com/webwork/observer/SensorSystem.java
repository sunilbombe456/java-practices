package com.webwork.observer;

import java.util.Enumeration;
import java.util.Vector;

import com.webwork.observer.interfaces.AlarmListener;

public class SensorSystem {
	 private Vector listeners = new Vector();

	    public void register(AlarmListener alarmListener) {
	        listeners.addElement(alarmListener);
	    }
	    
	    public void soundTheAlarm() {
	        for (Enumeration e = listeners.elements(); e.hasMoreElements();) {
	            ((AlarmListener) e.nextElement()).alarm();
	        }
	    }
}
