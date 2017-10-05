package basePackage;

// CONTENTS: 
//Car Types
//-types of car i.e. truck, van, sedan


//		 Required Layout:
// -!- (double) moneyMult - How much more they have to pay per unit of time compared to base pay
// -!- (String) spaceType - what type of spot they require i.e. sedans go in normal motorcycle goes in small bus goes in large
//-Types = Small, Normal, Large;

/*	-VEHICLES-	*/


// IMPORTANT:
// in order to add a new vehicle you must:
// 1. put your Car in CAR_TYPES
// 2. put your Car in displayArray with the existing format
// 3. create a class in this .java with your vehicle's name, following existing format



public class CarClasses {
	static final String[] CAR_TYPES = {"WorkTruck", "PickupTruck","Van","Sedan", "Motorcycle", "Bus", "Handicap"};
	
	
	
	public Car displayArray(String name, String model, String make, String year, String platenum, int spotnum) {
		if (name.equals("WorkTruck")) { return new WorkTruck(model, make, year, platenum, spotnum); }
		if (name.equals("PickupTruck")) { return new PickupTruck(model, make, year, platenum, spotnum); }
		if (name.equals("Van")) { return new Van(model, make, year, platenum, spotnum); }
		if (name.equals("Sedan")) { return new Sedan(model, make, year, platenum, spotnum); }
		if (name.equals("Motorcycle")) { return new Motorcycle(model, make, year, platenum, spotnum); }
		if (name.equals("Bus")) { return new Bus(model, make, year, platenum, spotnum); }
		if (name.equals("Handicap")) { return new Handicap(model, make, year, platenum, spotnum); }
		return null;		// cannot return null due to the requirement to get to this point (selecting existing type from dropdown)
	}
}


class WorkTruck extends Car {
	
	private static double moneyMult = 5.0;
	private static String spaceType = "Large";
	
	public WorkTruck(String model, String make, String year, String platenum, int spotnum) {
		super(model, make, year, platenum, spotnum, spaceType, moneyMult);
	}
}

class PickupTruck extends Car {
	
	private static double moneyMult = 3.0;
	private static String spaceType = "Normal";
	
	
	public PickupTruck(String model, String make, String year, String platenum, int spotnum) {
		super(model, make, year, platenum, spotnum, spaceType, moneyMult);
	}
}

class Van extends Car {
	
	private static double moneyMult = 2.5;
	private static String spaceType = "Normal";
	
	public Van(String model, String make, String year, String platenum, int spotnum) {
		super(model, make, year, platenum, spotnum, spaceType, moneyMult);
	}
}

class Sedan extends Car {
	
	private static double moneyMult = 1.0;
	private static String spaceType = "Normal";
	
	public Sedan(String model, String make, String year, String platenum, int spotnum) {
		super(model, make, year, platenum, spotnum, spaceType, moneyMult);
	}
}

class Motorcycle extends Car {
	private static String spaceType = "Small";
	private static double moneyMult = 0.85;
	
	public Motorcycle(String model, String make, String year, String platenum, int spotnum) {
		super(model, make, year, platenum, spotnum, spaceType, moneyMult);
	}
}

class Bus extends Car {
	
	private static double moneyMult = 4.0;
	private static String spaceType = "Small";
	
	public Bus(String model, String make, String year, String platenum, int spotnum) {
		super(model, make, year, platenum, spotnum, spaceType, moneyMult);
	}
}

class Handicap extends Car {
	
	private static double moneyMult = 0.99;
	private static String spaceType = "Handicapped";	// i will go on the assumption that a bus cannot be considered "handicapped"
									// and/or a huge work truck cannot be handicapped, neither can a motorcycle
	
	public Handicap(String model, String make, String year, String platenum, int spotnum) {
		super(model, make, year, platenum, spotnum, spaceType, moneyMult);
	}
}