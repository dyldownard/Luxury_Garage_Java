package carsPackage;

import java.io.Serializable;
import java.time.LocalDate;

import basePackage.CarsArray;
import basePackage.Floor;
import guiApplication.ToolTipStackPane;
import javafx.scene.paint.Color;
import ticketsPackage.*;
/**
 * Car abstract-class that defines and outlines the basis for all vehicles
 *
 */
public abstract class Car implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2685261214214120697L;

	/**
	 * tick Ticket attatched to car
	 */
	private Ticket tick;
	
	/**
	 * model model of car
	 * make make of car
	 * year year car was made
	 * platenum platenumber of car
	 * spotnum spot where car is parked
	 */
	private String model; private String make; 
	private String year; private String platenum;
	private int spotnum;
	/**
	 * LocalDate to store for comparison later
	 */
	public LocalDate localDate;
	
	private Floor myFloor;
	private CarsArray myFloorCarAr;
	
	/**
	 * spotGlobablArray position in the ParkingGarage array
	 */
	private int spotGlobalArray;
	
	private ToolTipStackPane myPane;
	private transient Color color;
	/**
	 * colorS String form of color, since color cannot be serialized
	 */
	private String colorS;
	/**
	 * spaceType type of space the car occupies
	 */
	private String spaceType;
	/**
	 * MONEY_MULT multiplier for the rate the car has to pay
	 */
	public final double MONEY_MULT;
	
	//--------------------------------------------------------	
	/**
	 * Constructor for car
	 * @param model model of car
	 * @param make make of car
	 * @param year year of car
	 * @param platenum plate# on car
	 * @param color color of car
	 * @param spotnum spot the car resides in
	 * @param spaceType type of space the car takes up
	 * @param moneyMult money rate multipier
	 */
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
	/**
	 * updates the actual Color of the car
	 */
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
