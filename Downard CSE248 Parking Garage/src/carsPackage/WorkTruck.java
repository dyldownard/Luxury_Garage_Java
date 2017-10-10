package carsPackage;

import javafx.scene.paint.Color;

public class WorkTruck extends Car {
	
	final public static double MONEY_MULT = 5.0;
	final public static String spaceType = "Large";
	
	public WorkTruck(String model, String make, String year, String platenum, Color color, int spotnum) {
		super(model, make, year, platenum, color, spotnum, spaceType, MONEY_MULT);
	}
}