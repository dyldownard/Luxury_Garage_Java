package basePackage;

public class ParkingGarage {

	final static double BASE_RATE = 1.0; // base payment scale, multiplicitive (per hour)
	
	// Objects
	protected static CarsArray cArray;
	private FloorsArray fArray;
	private TicketArray tArray;
	private Car currentCar;
	private Floor currentFloor;
	
	// ints for numbers of stuff. Equation: (100*amountFloors) = amountCars + amountSpaces
	final private int amountFloors = 3;			// Amount of Floors to be configured
	final private int amountTotalSpaces = 300;	// Total spaces on lot
	
	protected static int TOTAL_amountCars;						// Amount of cars currently parked 
	protected static int TOTAL_amountEmptySpaces;				// Amount of empty spaces on lot
	
	
	public ParkingGarage() {
		TOTAL_amountEmptySpaces = amountTotalSpaces;
		cArray = new CarsArray(amountTotalSpaces);
		fArray = new FloorsArray(amountFloors, amountTotalSpaces);
		tArray = new TicketArray(amountTotalSpaces);
	}
	
	
	/* TODO Generate ticket number AFTER 
	public String parkCar(Car myCar, int floor, int space) {
		return fArray.parkCar(myCar, floor, space);
	}
	*/
	
	public String parkValet(Car myCar) {
		if (myCar.getSpaceType().equals("Normal") || myCar.getSpaceType().equals("Handicapped")) {
			return fArray.parkValet(myCar);
		}
		return "Vehicle not permitted for Valet becuase we're underpaid college students";
	}
	
	public static void CarParked() {
		TOTAL_amountCars++;
		cArray.amountCars++;
		TOTAL_amountEmptySpaces--;
		cArray.amountSpaces--;
	}
	

	public void printGarage() {
		System.out.println("||-------------------------------------------------||");
		System.out.println("Garage made sucessfully. Code: " + amountFloors + " " + TOTAL_amountCars + " " + amountTotalSpaces);
		System.out.println("\n" + fArray);
		fArray.printFloors();
		System.out.println("\n" + cArray);
		System.out.println("||-------------------------------------------------||");
	}
}
