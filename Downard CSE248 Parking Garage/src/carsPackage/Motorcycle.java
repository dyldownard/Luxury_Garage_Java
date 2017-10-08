package carsPackage;

import javafx.scene.paint.Color;

public class Motorcycle extends Car {
	private static String spaceType = "Small";
	private static double moneyMult = 0.85;
	
	public Motorcycle(String model, String make, String year, String platenum, Color color, int spotnum) {
		super(model, make, year, platenum, color, spotnum, spaceType, moneyMult);
	}
}