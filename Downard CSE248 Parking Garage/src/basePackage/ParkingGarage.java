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
	private int amountSpaces = 100;			// Amount of empty spaces on lot
	
	
	public ParkingGarage() {
		cArray = new CarsArray(amountFloors * amountSpaces);
		fArray = new FloorsArray(amountFloors, amountSpaces);
	}
	

	public void printGarage() {
		System.out.println("Garage made sucessfully. Code: " + amountFloors + " " + amountCars + " " + amountSpaces);
		System.out.println("\n" + fArray);
		fArray.printFloors();
	}
}
