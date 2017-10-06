package carsPackage;

class Bus extends Car {
	
	private static double moneyMult = 4.0;
	private static String spaceType = "Small";
	
	public Bus(String model, String make, String year, String platenum, int spotnum) {
		super(model, make, year, platenum, spotnum, spaceType, moneyMult);
	}
}