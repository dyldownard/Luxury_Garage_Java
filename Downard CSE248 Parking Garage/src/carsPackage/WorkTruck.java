package carsPackage;

class WorkTruck extends Car {
	
	private static double moneyMult = 5.0;
	private static String spaceType = "Large";
	
	public WorkTruck(String model, String make, String year, String platenum, int spotnum) {
		super(model, make, year, platenum, spotnum, spaceType, moneyMult);
	}
}