package basePackage;

public class ParkingGarage {

	// Objects
	private CarsArray cArray;
	private FloorsArray fArray;
	private Car currentCar;
	private Floor currentFloor;
	
	// ints for numbers of stuff. Equation: (100*amountFloors) = amountCars + amountSpaces
	private int amountFloors = 3;		// Amount of Floors to be configured
	private int amountCars;				// Amount of cars currently parked 
	private int amountSpaces;			// Amount of empty spaces on lot
	
	
	
	
	
	public ParkingGarage() {
		cArray = new CarsArray();
		fArray = new FloorsArray();
	}
	
}
