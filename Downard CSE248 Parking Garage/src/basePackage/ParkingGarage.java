package basePackage;

public class ParkingGarage {

	// Objects
	private CarsArray cArray;
	private FloorsArray fArray;
	private TicketArray tArray;
	private Car currentCar;
	private Floor currentFloor;
	
	// ints for numbers of stuff. Equation: (100*amountFloors) = amountCars + amountSpaces
	final private int amountFloors = 3;			// Amount of Floors to be configured
	final private int amountTotalSpaces = 300;	// Total spaces on lot
	
	private int amountCars;						// Amount of cars currently parked 
	private int amountEmptySpaces;				// Amount of empty spaces on lot
	
	
	public ParkingGarage() {
		amountEmptySpaces = amountTotalSpaces;
		cArray = new CarsArray(amountTotalSpaces);
		fArray = new FloorsArray(amountFloors, amountTotalSpaces);
		tArray = new TicketArray(amountTotalSpaces);
	}
	
	
	// TODO Generate ticket number AFTER 
	public boolean parkCarSpecific(Car myCar, int floor, int space) {
		
		return false;
	}
	public boolean parkCarNonspecific(Car myCar) {
		return fArray.parkCarNonspecific(myCar);
	}
	
	

	public void printGarage() {
		System.out.println("||-------------------------------------------------||");
		System.out.println("Garage made sucessfully. Code: " + amountFloors + " " + amountCars + " " + amountTotalSpaces);
		System.out.println("\n" + fArray);
		fArray.printFloors();
		System.out.println("\n" + cArray);
		System.out.println("||-------------------------------------------------||");
	}
}
