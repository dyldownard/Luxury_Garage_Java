package carsPackage;

class Handicap extends Car {
	
	private static double moneyMult = 0.99;
	private static String spaceType = "Handicapped";	// i will go on the assumption that a bus cannot be considered "handicapped"
									// and/or a huge work truck cannot be handicapped, neither can a motorcycle
	
	public Handicap(String model, String make, String year, String platenum, int spotnum) {
		super(model, make, year, platenum, spotnum, spaceType, moneyMult);
	}
}