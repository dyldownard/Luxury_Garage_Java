package carsPackage;

import javafx.scene.paint.Color;

public class Van extends Car {
	
	private static double moneyMult = 2.5;
	private static String spaceType = "Normal";
	
	public Van(String model, String make, String year, String platenum, Color color, int spotnum) {
		super(model, make, year, platenum, color, spotnum, spaceType, moneyMult);
	}
}