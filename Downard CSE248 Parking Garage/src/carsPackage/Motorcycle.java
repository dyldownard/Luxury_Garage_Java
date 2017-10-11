package carsPackage;

import javafx.scene.paint.Color;

public class Motorcycle extends Car {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7068638031849639309L;
	final public static String spaceType = "Motorcycle";
	final public static double MONEY_MULT = 0.85;
	/**
	 * constructor
	 * @param model model of car 
	 * @param make make of car
	 * @param year year of car
	 * @param platenum plate of car
	 * @param color color of car
	 * @param spotnum spot car is in
	 */
	public Motorcycle(String model, String make, String year, String platenum, Color color, int spotnum) {
		super(model, make, year, platenum, color, spotnum, spaceType, MONEY_MULT);
	}
}