package carsPackage;

import javafx.scene.paint.Color;
import ticketsPackage.*;

public abstract class Car {

	private Ticket tick;
	
	private String model; private String make; 
	private String year; private String platenum;
	private int spotnum;
	
	private Color color;
	
	private String spaceType;
	private double moneyMult;
	
	public Car(String model, String make, String year, String platenum, Color color, int spotnum, String spaceType, double moneyMult) {
		this.model = model;
		this.make = make;
		this.year = year;
		this.platenum = platenum;
		this.color = color;
		this.spotnum = spotnum;
		this.spaceType = spaceType;
		this.moneyMult = moneyMult;
	}
	
	public void setTicket(Ticket tick) {
		this.tick = tick;
		tick.setCar(this);
	}
	
	public Ticket getTicket() {
		return this.tick;
	}
	
	public double getMoneyMult() {
		return moneyMult;
	}
	
	public String getSpaceType() {
		return this.spaceType;
	}

	public Color getColor() {
		return this.color;
	}
	
	public String getModel() {
		return model;
	}

	public String getMake() {
		return make;
	}

	public String getYear() {
		return year;
	}

	public String getPlatenum() {
		return platenum;
	}

	public int getSpotnum() {
		return spotnum;
	}

	@Override
	public String toString() {
		return "ye";
	}
}
