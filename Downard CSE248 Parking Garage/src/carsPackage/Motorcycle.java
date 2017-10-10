package carsPackage;

import javafx.scene.paint.Color;

public class Motorcycle extends Car {
	final public static String spaceType = "Motorcycle";
	final public static double MONEY_MULT = 0.85;
	
	public Motorcycle(String model, String make, String year, String platenum, Color color, int spotnum) {
		super(model, make, year, platenum, color, spotnum, spaceType, MONEY_MULT);
	}
}