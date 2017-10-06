package carsPackage;

import javafx.scene.paint.Color;

public class Sedan extends Car {
	
	private static double moneyMult = 1.0;
	private static String spaceType = "Normal";
	
	public Sedan(String model, String make, String year, String platenum, Color color, int spotnum) {
		super(model, make, year, platenum, color, spotnum, spaceType, moneyMult);
	}
}