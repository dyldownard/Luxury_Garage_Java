package carsPackage;

import javafx.scene.paint.Color;

public class Handicap extends Car {
	
	final public static double MONEY_MULT = 0.99;
	final public static String spaceType = "Handicapped";	// i will go on the assumption that a bus cannot be considered "handicapped"
									// and/or a huge work truck cannot be handicapped, neither can a motorcycle
	
	public Handicap(String model, String make, String year, String platenum, Color color, int spotnum) {
		super(model, make, year, platenum, color, spotnum, spaceType, MONEY_MULT);
	}
}