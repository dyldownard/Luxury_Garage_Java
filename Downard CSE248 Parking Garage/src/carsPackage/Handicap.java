package carsPackage;

import javafx.scene.paint.Color;

public class Handicap extends Car {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5002157763395449384L;
	final public static double MONEY_MULT = 0.99;
	final public static String spaceType = "Handicapped";	// i will go on the assumption that a bus cannot be considered "handicapped"
									// and/or a huge work truck cannot be handicapped, neither can a motorcycle
	/**
	 * constructor
	 * @param model model of car 
	 * @param make make of car
	 * @param year year of car
	 * @param platenum plate of car
	 * @param color color of car
	 * @param spotnum spot car is in
	 */
	public Handicap(String model, String make, String year, String platenum, Color color, int spotnum) {
		super(model, make, year, platenum, color, spotnum, spaceType, MONEY_MULT);
	}
}