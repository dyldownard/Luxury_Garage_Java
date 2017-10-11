package basePackage;

import java.io.Serializable;

import carsPackage.Car;
import guiApplication.GUIFloor;
import guiApplication.ToolTipStackPane;
import ticketsPackage.Ticket;
/**
 * @author Dylan Downard
 * @author downd98@mail.sunysuffolk.edu
 * @author https://github.com/battlebutts
 * @version 1.0
 * 
 */
public class ParkingGarage implements Serializable{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -5986639838217277569L;
	/**
	 * BASE_RATE base rate of pay. works off multiplication, set higher for 'realistic' city prices
	 * rate = BASE_RATE * (ticketRate/time * vehicleRate)
	 */
	final public double BASE_RATE = 1.0; 
	/**
	 * FLOORS array of floor types that get added to FloorsArray
	 */
	final public String[] FLOORS = {"GroundFloor", "NormalFloor", "NormalFloor"};
	/**
	 * AMOUNT_TOTAL_SPACES amount of inital non-special spaces, gets added to after special floors are made
	 */
	public int AMOUNT_TOTAL_SPACES = 300;
	
	/**
	 * CAR_TYPES different types of vehicles, if any vehicle is added it must also be put in here
	 */
	final public String[] CAR_TYPES = {"WorkTruck", "PickupTruck","Van","Sedan", "Motorcycle", "Bus", "Handicap"};
	/**
	 * TICKET_TYPES different types of ticket, if any ticket is added it must also be put in here
	 */
	final public String[] TICKET_TYPES = {"HourlyRate", "MinutelyRate", "MonthlyRate"};
	
	
	
	// Objects
	/**
	 * cArray - ParkingGarage's Global CarArray
	 */
	private CarsArray cArray;
	/**
	 * fArray - ParkingGarage's Floor Array
	 */
	private FloorsArray fArray;
	
	/**
	 * tickAr - Backup array of tickets in-case references somehow get screwed up upon serialization (most likely going to deprecate)
	 */
	public Ticket[] tickAr;
	
	
	/**
	 * TOTAL_amountCars Cars parked in the lot
	 */
	protected int TOTAL_amountCars;						// Amount of cars currently parked 
	/**
	 * TOTAL_amountEmptySpaces amount of spaces on lot
	 */
	protected int TOTAL_amountEmptySpaces;				// Amount of empty spaces on lot
	
	//--------------------------------------------------------	
	
	/**
	 * Constructor for the Garage
	 */
	public ParkingGarage() {
		TOTAL_amountEmptySpaces = AMOUNT_TOTAL_SPACES;
		fArray = new FloorsArray(FLOORS, AMOUNT_TOTAL_SPACES, this);
		cArray = new CarsArray(AMOUNT_TOTAL_SPACES, this);
		tickAr = new Ticket[AMOUNT_TOTAL_SPACES];
	}
	
	//--------------------------------------------------------	
	
	/**
	 * Parks car in a specific spot on the lot.
	 * @param myCar Car to be parked
	 * @param realTick Ticket being added to car
	 * @param floor GUIFloor car came from
	 * @param spotnum Spot of car
	 * @param pane Pane car was made with
	 * @return String of if the car is parked or not. only for testing purposes
	 */
	public String parkCar(Car myCar, Ticket realTick, GUIFloor floor, int spotnum, ToolTipStackPane pane) {
		myCar.setTicket(realTick);
		addTicket(realTick);
		return fArray.parkCar(myCar, floor, spotnum, pane);
	}
	
	/**
	 * Parks the car in the first available spot in the lot
	 * @param myCar car to be parked
	 * @param realTick ticket being added to car
	 * @return
	 */
	public String parkValet(Car myCar, Ticket realTick) {
		myCar.setTicket(realTick);
		addTicket(realTick);
		return fArray.parkValet(myCar, this);
	}
	
	//--------------------------------------------------------	
	
	/**
	 * Checks if all tickets are set to their cars
	 */
	public void CheckTicks() {
		for (int i = 0; i < AMOUNT_TOTAL_SPACES; i++) {
			if (cArray.getAr()[i] != null && tickAr[i] != null) {
				cArray.getAr()[i].setTicket(tickAr[i]);
				tickAr[i].setCar(cArray.getAr()[i]);
			}
		}
	}
	
	/**
	 * Adds tickets to array
	 * @param myTick ticket to be added
	 */
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
	
	/**
	 * removes ticket from array
	 * @param spot where ticket resides in array
	 */
	public void removeTicket(int spot) {
		tickAr[spot] = null;
	}
	
	//--------------------------------------------------------	
	
	/**
	 * searches for ticket in array
	 * @param number TicketNumber to search for
	 * @return car that has the ticket
	 */
	public Car searchTicket(String number) {
		return cArray.searchTicket(number);
	}
	
	/**
	 * searches for car in array
	 * @param plate search term
	 * @return car that has the plate#
	 */
	public Car searchCar(String plate) {
		return cArray.searchPlate(plate);
	}
	
	//--------------------------------------------------------	
	
	/**
	 * @return if the lot is full
	 */
	public boolean isFull() {
		return TOTAL_amountCars == AMOUNT_TOTAL_SPACES;
	}
	
	/**
	 * counter for lot when parked
	 */
	public void CarParked() {
		TOTAL_amountCars++;
		TOTAL_amountEmptySpaces--;
	}
	
	/**
	 * counter for the lot when pickedup
	 */
	public void CarPicked() {
		TOTAL_amountCars--;
		TOTAL_amountEmptySpaces--;
	}
	
	
	/**
	 * @return floorArray
	 */
	public FloorsArray getFloorsArray() {
		return fArray;
	}
	
	/**
	 * @return carsArray
	 */
	public CarsArray getCarsArray() {
		return cArray;
	}

	/**
	 * @return amount of cars in lot
	 */
	public int getAmountCars() {
		return TOTAL_amountCars;
	}
}
