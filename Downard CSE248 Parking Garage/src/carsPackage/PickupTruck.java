package carsPackage;

class PickupTruck extends Car {
	
	private static double moneyMult = 3.0;
	private static String spaceType = "Normal";
	
	
	public PickupTruck(String model, String make, String year, String platenum, int spotnum) {
		super(model, make, year, platenum, spotnum, spaceType, moneyMult);
	}
}