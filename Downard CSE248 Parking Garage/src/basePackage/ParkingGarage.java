package basePackage;

public class ParkingGarage {

	final public static double BASE_RATE = 1.0; // base payment scale, multiplicitive (per hour)
	final public static int AMOUNT_FLOORS = 3;			// Amount of Floors to be configured
	final public static int AMOUNT_TOTAL_SPACES = 300;	// Total spaces on lot
	
	// Objects
	protected static CarsArray cArray;
	private FloorsArray fArray;
	private TicketArray tArray;
	private Car currentCar;
	private Floor currentFloor;
	
	// ints for numbers of stuff. Equation: (100*amountFloors) = amountCars + amountSpaces
	
	protected static int TOTAL_amountCars;						// Amount of cars currently parked 
	protected static int TOTAL_amountEmptySpaces;				// Amount of empty spaces on lot
	
	
	public ParkingGarage() {
		TOTAL_amountEmptySpaces = AMOUNT_TOTAL_SPACES;
		cArray = new CarsArray(AMOUNT_TOTAL_SPACES);
		fArray = new FloorsArray(AMOUNT_FLOORS, AMOUNT_TOTAL_SPACES);
		tArray = new TicketArray(AMOUNT_TOTAL_SPACES);
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
	
	public FloorsArray getFloorsArray() {
		return fArray;
	}
	
	public int getAmountCars() {
		return TOTAL_amountCars;
	}

	public void printGarage() {
		System.out.println("||-------------------------------------------------||");
		System.out.println("Garage made sucessfully. Code: " + AMOUNT_FLOORS + " " + TOTAL_amountCars + " " + AMOUNT_TOTAL_SPACES);
		System.out.println("\n" + fArray);
		fArray.printFloors();
		System.out.println("\n" + cArray);
		System.out.println("||-------------------------------------------------||");
	}
}
