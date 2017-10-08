package carsPackage;

import javafx.scene.paint.Color;

public class WorkTruck extends Car {
	
	private static double moneyMult = 5.0;
	private static String spaceType = "Large";
	
	public WorkTruck(String model, String make, String year, String platenum, Color color, int spotnum) {
		super(model, make, year, platenum, color, spotnum, spaceType, moneyMult);
	}
}