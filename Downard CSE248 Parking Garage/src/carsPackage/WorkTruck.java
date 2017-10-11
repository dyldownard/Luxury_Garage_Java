package carsPackage;

import javafx.scene.paint.Color;

public class WorkTruck extends Car {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1954148581072046924L;
	final public static double MONEY_MULT = 5.0;
	final public static String spaceType = "Large";
	/**
	 * constructor
	 * @param model model of car 
	 * @param make make of car
	 * @param year year of car
	 * @param platenum plate of car
	 * @param color color of car
	 * @param spotnum spot car is in
	 */
	public WorkTruck(String model, String make, String year, String platenum, Color color, int spotnum) {
		super(model, make, year, platenum, color, spotnum, spaceType, MONEY_MULT);
	}
}