package carsPackage;

import javafx.scene.paint.Color;

public class PickupTruck extends Car {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2304563838139404983L;
	final public static double MONEY_MULT = 3.0;
	final public static String spaceType = "Normal";
	
	/**
	 * constructor
	 * @param model model of car 
	 * @param make make of car
	 * @param year year of car
	 * @param platenum plate of car
	 * @param color color of car
	 * @param spotnum spot car is in
	 */
	public PickupTruck(String model, String make, String year, String platenum, Color color, int spotnum) {
		super(model, make, year, platenum, color, spotnum, spaceType, MONEY_MULT);
	}
}