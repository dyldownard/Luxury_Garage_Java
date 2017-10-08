package carsPackage;

import javafx.scene.paint.Color;

public class PickupTruck extends Car {
	
	private static double moneyMult = 3.0;
	private static String spaceType = "Normal";
	
	
	public PickupTruck(String model, String make, String year, String platenum, Color color, int spotnum) {
		super(model, make, year, platenum, color, spotnum, spaceType, moneyMult);
	}
}