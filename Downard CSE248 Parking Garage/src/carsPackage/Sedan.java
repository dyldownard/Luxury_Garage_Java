package carsPackage;

import javafx.scene.paint.Color;

public class Sedan extends Car {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -283623584712285759L;
	final public static double MONEY_MULT = 1.0;
	final public static String spaceType = "Normal";
	
	public Sedan(String model, String make, String year, String platenum, Color color, int spotnum) {
		super(model, make, year, platenum, color, spotnum, spaceType, MONEY_MULT);
	}
}