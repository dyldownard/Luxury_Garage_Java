package basePackage;

import java.io.Serializable;

import carsPackage.Car;
import guiApplication.GUIFloor;
import guiApplication.ToolTipStackPane;
import ticketsPackage.Ticket;

public class ParkingGarage implements Serializable{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -5986639838217277569L;
	final public double BASE_RATE = 1.0; // base payment scale, multiplicitive (per hour)
	final public String[] FLOORS = {"GroundFloor", "NormalFloor", "NormalFloor"};
	public int AMOUNT_TOTAL_SPACES = 300;	// Total NORMAL (non-motorcycle or bus or handicap) spaces on lot
	
	final public String[] CAR_TYPES = {"WorkTruck", "PickupTruck","Van","Sedan", "Motorcycle", "Bus", "Handicap"};
	final public String[] TICKET_TYPES = {"HourlyRate", "MinutelyRate", "MonthlyRate"};
	
	
	
	// Objects
	private CarsArray cArray;
	private FloorsArray fArray;
	
	public Ticket[] tickAr;
	
	// ints for numbers of stuff. Equation: (100*amountFloors) = amountCars + amountSpaces
	
	protected int TOTAL_amountCars;						// Amount of cars currently parked 
	protected int TOTAL_amountEmptySpaces;				// Amount of empty spaces on lot
	
	
	public ParkingGarage() {
		TOTAL_amountEmptySpaces = AMOUNT_TOTAL_SPACES;
		fArray = new FloorsArray(FLOORS, AMOUNT_TOTAL_SPACES, this);
		cArray = new CarsArray(AMOUNT_TOTAL_SPACES, this);
		tickAr = new Ticket[AMOUNT_TOTAL_SPACES];
	}
	
	public String parkCar(Car myCar, Ticket realTick, GUIFloor floor, int spotnum, ToolTipStackPane pane) {
		myCar.setTicket(realTick);
		addTicket(realTick);
		return fArray.parkCar(myCar, floor, spotnum, pane);
	}
	
	public void CheckTicks() {
		for (int i = 0; i < AMOUNT_TOTAL_SPACES; i++) {
			if (cArray.getAr()[i] != null && tickAr[i] != null) {
				cArray.getAr()[i].setTicket(tickAr[i]);
				tickAr[i].setCar(cArray.getAr()[i]);
			}
		}
	}
	
	public void addTicket(Ticket myTick) {
		int temp = 0;
		for (int i = 0; i < tickAr.length; i++) {
			if (tickAr[i] == null) {
				temp = i;
			}
		}
		tickAr[temp] = myTick;
		myTick.setTicketGlobal(temp);
	}
	
	public void removeTicket(int spot) {
		tickAr[spot] = null;
	}
	
	public String parkValet(Car myCar, Ticket realTick) {
		myCar.setTicket(realTick);
		addTicket(realTick);
		return fArray.parkValet(myCar, this);
	}
	
	public Car searchTicket(String number) {
		return cArray.searchTicket(number);
	}
	
	public Car searchCar(String plate) {
		return cArray.searchPlate(plate);
	}
	
	public boolean isFull() {
		return TOTAL_amountCars == AMOUNT_TOTAL_SPACES;
	}
	
	public void CarParked() {
		TOTAL_amountCars++;
		TOTAL_amountEmptySpaces--;
	}
	
	public void CarPicked() {
		TOTAL_amountCars--;
		TOTAL_amountEmptySpaces--;
	}
	
	
	public FloorsArray getFloorsArray() {
		return fArray;
	}
	
	public CarsArray getCarsArray() {
		return cArray;
	}

	public int getAmountCars() {
		return TOTAL_amountCars;
	}

	@Override
	public String toString() {
		return TOTAL_amountCars + " " ;
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
