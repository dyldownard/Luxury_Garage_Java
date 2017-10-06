package carsPackage;

class Van extends Car {
	
	private static double moneyMult = 2.5;
	private static String spaceType = "Normal";
	
	public Van(String model, String make, String year, String platenum, int spotnum) {
		super(model, make, year, platenum, spotnum, spaceType, moneyMult);
	}
}