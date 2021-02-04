package com.webwork.observer.interfaces.impl;

import com.webwork.observer.CheckList;
import com.webwork.observer.interfaces.AlarmListener;

public class Surveillance extends CheckList implements AlarmListener {

	@Override
	public void alarm() {
		// TODO Auto-generated method stub
		System.out.println("Surveillance - by the numbers:");
		byTheNumbers();
	}

	protected void isolate() {
		System.out.println("   train the cameras");
	}

}
