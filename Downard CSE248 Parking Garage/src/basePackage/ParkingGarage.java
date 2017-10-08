package basePackage;

import carsPackage.Car;
import guiApplication.GUIFloor;
import guiApplication.ToolTipStackPane;
import ticketsPackage.Ticket;

public class ParkingGarage {

	final public static double BASE_RATE = 1.0; // base payment scale, multiplicitive (per hour)
	final public static String[] FLOORS = {"NormalFloor", "NormalFloor", "NormalFloor"};
	public static int AMOUNT_TOTAL_SPACES = 300;	// Total NORMAL (non-motorcycle or bus or handicap) spaces on lot
	
	final public static String[] CAR_TYPES = {"WorkTruck", "PickupTruck","Van","Sedan", "Motorcycle", "Bus", "Handicap"};
	final public static String[] TICKET_TYPES = {"HourlyRate", "MinutelyRate", "MonthlyRate"};
	
	
	
	// Objects
	protected static CarsArray cArray;
	private FloorsArray fArray;
	private TicketArray tArray;
	
	// ints for numbers of stuff. Equation: (100*amountFloors) = amountCars + amountSpaces
	
	protected static int TOTAL_amountCars;						// Amount of cars currently parked 
	protected static int TOTAL_amountEmptySpaces;				// Amount of empty spaces on lot
	
	
	public ParkingGarage() {
		TOTAL_amountEmptySpaces = AMOUNT_TOTAL_SPACES;
		cArray = new CarsArray(AMOUNT_TOTAL_SPACES);
		fArray = new FloorsArray(FLOORS, AMOUNT_TOTAL_SPACES, this);
		tArray = new TicketArray(AMOUNT_TOTAL_SPACES);
	}
	
	public String parkCar(Car myCar, Ticket realTick, GUIFloor floor, int spotnum, ToolTipStackPane pane) {
		myCar.setTicket(realTick);
		return fArray.parkCar(myCar, floor, spotnum, pane);
	}
	
	
	//TODO when attempting to park handicap / motor, TRY to park via handi/motor first( if handi cap for i handi, for i normal)
	public String parkValet(Car myCar, Ticket realTick) {
		myCar.setTicket(realTick);
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
	
	public TicketArray getTicketsArray() {
		return tArray;
	}
	
	public int getAmountCars() {
		return TOTAL_amountCars;
	}

	public void printGarage() {
		System.out.println("||-------------------------------------------------||");
		System.out.println("Garage made sucessfully. Code: "  + " " + TOTAL_amountCars + " " + AMOUNT_TOTAL_SPACES);
		System.out.println("\n" + fArray);
		fArray.printFloors();
		System.out.println("\n" + cArray);
		System.out.println("||-------------------------------------------------||");
	}
}
