package carsPackage;

class Motorcycle extends Car {
	private static String spaceType = "Small";
	private static double moneyMult = 0.85;
	
	public Motorcycle(String model, String make, String year, String platenum, int spotnum) {
		super(model, make, year, platenum, spotnum, spaceType, moneyMult);
	}
}