package carsPackage;

import javafx.scene.paint.Color;

public class Van extends Car {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7035069681938610183L;
	final public static double MONEY_MULT = 2.5;
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
	public Van(String model, String make, String year, String platenum, Color color, int spotnum) {
		super(model, make, year, platenum, color, spotnum, spaceType, MONEY_MULT);
	}
}