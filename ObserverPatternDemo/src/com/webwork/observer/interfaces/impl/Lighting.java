package com.webwork.observer.interfaces.impl;

import com.webwork.observer.interfaces.AlarmListener;

public class Lighting implements AlarmListener {

	@Override
	public void alarm() {
		// TODO Auto-generated method stub
		System.out.println("lights up");
	}

}
