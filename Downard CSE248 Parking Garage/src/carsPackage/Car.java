package carsPackage;

import java.io.Serializable;
import java.time.LocalDate;

import basePackage.CarsArray;
import basePackage.Floor;
import guiApplication.ToolTipStackPane;
import javafx.scene.paint.Color;
import ticketsPackage.*;

public abstract class Car implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2685261214214120697L;

	private Ticket tick;
	
	private String model; private String make; 
	private String year; private String platenum;
	private int spotnum;
	
	public LocalDate localDate;
	
	private Floor myFloor;
	private CarsArray myFloorCarAr;
	
	private int spotGlobalArray;
	
	private ToolTipStackPane myPane;
	private transient Color color;
	private String colorS;
	
	private String spaceType;
	public final double MONEY_MULT;
	
	//--------------------------------------------------------	
	
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
	
	//--------------------------------------------------------	
	
	public void updateColor() {
		Color newCol = Color.BLACK;
		if (colorS.equals("Black")) {
			newCol = Color.BLACK;
		}else if(colorS.equals("White")) {
			newCol = Color.WHITE;
		}else if(colorS.equals("Red")) {
			newCol = Color.RED;
		}else if(colorS.equals("Blue")) {
			newCol = Color.BLUE;
		}else if(colorS.equals("Gray")) {
			newCol = Color.GRAY;
		}
		this.color = newCol;
	}
	
	//--------------------------------------------------------	
	
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
	public void setColor(Color color, String colorS) {
		this.color = color;
		this.colorS = colorS;
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
		return "Vroom";
	}

	public ToolTipStackPane getMyPane() {
		return myPane;
	}

	public void setMyPane(ToolTipStackPane myPane) {
		this.myPane = myPane;
	}
}
