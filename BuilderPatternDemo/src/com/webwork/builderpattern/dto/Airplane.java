package com.webwork.builderpattern.dto;

public class Airplane {
	private String type;
	private float wingspan;
	private String powerplant;
	private int crewSeats;
	private int passengerSeats;
	private String avionics;
	private String customer;

	public Airplane(String customer, String type) {
		this.customer = customer;
		this.type = type;
	}

	public void setWingspan(float wingspan) {
		this.wingspan = wingspan;
	}

	public void setPowerplant(String powerplant) {
		this.powerplant = powerplant;
	}

	public void setAvionics(String avionics) {
		this.avionics = avionics;
	}

	public void setNumberSeats(int crewSeats, int passengerSeats) {
		this.crewSeats = crewSeats;
		this.passengerSeats = passengerSeats;
	}

	public String getCustomer() {
		return customer;
	}

	public String getType() {
		return type;
	}

	@Override
	public String toString() {
		return "Airplane [type=" + type + ", wingspan=" + wingspan + ", powerplant=" + powerplant + ", crewSeats="
				+ crewSeats + ", passengerSeats=" + passengerSeats + ", avionics=" + avionics + ", customer=" + customer
				+ "]";
	}

}
