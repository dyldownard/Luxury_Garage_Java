package carsPackage;

import javafx.scene.paint.Color;

public class Bus extends Car {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4995663028072599722L;
	final public static double MONEY_MULT = 4.0;
	final public static String spaceType = "Small";
	
	public Bus(String model, String make, String year, String platenum, Color color, int spotnum) {
		super(model, make, year, platenum, color, spotnum, spaceType, MONEY_MULT);
	}

}