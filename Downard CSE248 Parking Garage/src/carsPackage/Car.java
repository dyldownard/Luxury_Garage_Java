package carsPackage;

import java.io.Serializable;

import basePackage.CarsArray;
import basePackage.Floor;
import guiApplication.ToolTipStackPane;
import javafx.scene.paint.Color;
import ticketsPackage.*;

public abstract class Car implements Serializable{

	private Ticket tick;
	
	private String model; private String make; 
	private String year; private String platenum;
	private int spotnum;
	
	private Floor myFloor;
	private CarsArray myFloorCarAr;
	
	private int spotGlobalArray;
	
	private ToolTipStackPane myPane;
	private Color color;
	
	private String spaceType;
	public final double MONEY_MULT;
	
	public Car(String model, String make, String year, String platenum, Color color, int spotnum, String spaceType, double moneyMult) {
		this.model = model;
		this.make = make;
		this.year = year;
		this.platenum = platenum;
		this.color = color;
		this.spotnum = spotnum;
		this.spaceType = spaceType;
		this.MONEY_MULT = moneyMult;
	}
	
	public void setTicket(Ticket tick) {
		this.tick = tick;
		tick.setCar(this);
	}
	
	public Ticket getTicket() {
		return this.tick;
	}
	
	public double getMoneyMult() {
		return MONEY_MULT;
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

	public void setSpotNum(int spot) {
		this.spotnum = spot;
	}
	
	public int getSpotnum() {
		return spotnum;
	}
	public void setFloor(Floor myFloor) {
		this.myFloor = myFloor;
	}
	public Floor getFloor() {
		return this.myFloor;
	}
	public void setFloorCarAr(CarsArray carAr) {
		this.myFloorCarAr = carAr;
	}
	public CarsArray getFloorCarAr() {
		return this.myFloorCarAr;
	}
	
	public void PickCar() {
		this.myFloorCarAr.CarPicked(this, spotnum);
	}
	public int getSpotGlobalArray() {
		return spotGlobalArray;
	}

	public void setSpotGlobalArray(int spotGlobalArray) {
		this.spotGlobalArray = spotGlobalArray;
	}

	@Override
	public String toString() {
		return "ye";
	}

	public ToolTipStackPane getMyPane() {
		return myPane;
	}

	public void setMyPane(ToolTipStackPane myPane) {
		this.myPane = myPane;
	}
}
