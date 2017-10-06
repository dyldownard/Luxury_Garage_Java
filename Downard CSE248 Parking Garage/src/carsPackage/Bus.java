package carsPackage;

import javafx.scene.paint.Color;

class Bus extends Car {
	
	private static double moneyMult = 4.0;
	private static String spaceType = "Small";
	
	public Bus(String model, String make, String year, String platenum, Color color, int spotnum) {
		super(model, make, year, platenum, color, spotnum, spaceType, moneyMult);
	}
}