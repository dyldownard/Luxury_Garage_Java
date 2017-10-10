package basePackage;

import java.io.Serializable;

import carsPackage.*;
import guiApplication.GUIFloor;

/**
 * @author Dylan
 * @author https://github.com/battlebutts
 *	@version 1.0
 * 
 */

public class CarsArray implements Serializable{



	private static final long serialVersionUID = -5068452776469704527L;
	private Car[] aR;
	protected int amountCars;
	protected int amountSpaces;
	private ParkingGarage mygarage;
	/**
	 * aR is an Array of Car objects
	 * amountCars represents the amount of car elements in the array
	 * amountSpaces represents empty spaces in the array
	 * mygarage represents the ParkingGarage parent object
	 */
	
	//--------------------------------------------------------	
	
	/**
	 * Constructor
	 * @param amount Size of array
	 * @param mygarage Parent ParkingGarage
	 */
	public CarsArray(int amount, ParkingGarage mygarage) {
		this.mygarage = mygarage;
		aR = new Car[amount];
		amountCars = 0;
		amountSpaces = amount;
	}
	
	//--------------------------------------------------------	

	/**
	 * Park Car via Spot
	 * @param myCar Car being parked
	 * @param floor Parent floor
	 * @param space Space car is going into
	 * 
	 */
	public String parkCar(Car myCar, GUIFloor floor, int space) {
		System.out.println(space + "space");
		aR[space] = myCar;
		myCar.setSpotNum(space);
		amountSpaces--;
		amountCars++;
		floor.getGarage().CarParked();
		floor.getGarage().getCarsArray().AddCarLot(myCar);
		return "Car Parked.";
	}
	
	/**
	 * Park Car via Valet
	 * @param myCar Car being parked
	 * @param park Parent ParkingGarage
	 * 
	 */
	public String parkValet(Car myCar, ParkingGarage park) {
		this.mygarage = park;
		int temp = 0;			//making sure that it gets the first slot available
		for (int i = 0; i < aR.length; i++) {
			if (aR[i] == null) {
				temp = i;
				break;
			}
		}
		aR[temp] = myCar;
		myCar.setSpotNum(temp);
		amountSpaces--;
		amountCars++;
		park.CarParked();
		park.getCarsArray().AddCarLot(myCar);
		return "Car Parked.";
	}
	
	//--------------------------------------------------------	
	
	/**
	 * Car being Picked Up
	 * @param myCar Car being picked up
	 * @param spotnum Spot Car is being picked from
	 */
	public void CarPicked(Car myCar, int spotnum) {
		amountSpaces++;
		amountCars--;
		mygarage.CarPicked();
		mygarage.removeTicket(myCar.getSpotGlobalArray());
		this.aR[spotnum] = null;
		myCar.getFloor().carPicked(myCar);

	}

	//--------------------------------------------------------	
	
	/** 
	 *  Adds car to Parent ParkingGarage lot
	 * @param myCar Car being added to global lot
	 */
	public void AddCarLot(Car myCar) {		// used in global
		int temp = 0;			//making sure that it gets the first slot available
		for (int i = 0; i < aR.length; i++) {
			if (aR[i] == null) {
				temp = i;
				break;
			}
		}
		aR[temp] = myCar;
		myCar.setSpotGlobalArray(temp);
		mygarage.addTicket(myCar.getTicket());
		amountSpaces--;
		amountCars++;
	}
	
	//--------------------------------------------------------	
	
	/**
	 * Searched car array for ticket
	 * @param tick Ticket to search for
	 * 
	 */
	public Car searchTicket(String tick) {
		for (int i = 0; i < aR.length; i++) {
			if (aR[i] == null) {
				return null;
			}
			if (tick.equals(aR[i].getTicket().getTickNum())) {
				return aR[i];
			}
		}
		return null;
	}
	
	
	/**
	 * Searches through cars for plate#
	 * @param String plate Plate String to search for
	 * 
	 */
	public Car searchPlate(String plate) {
		for (int i = 0; i < aR.length; i++) {
			if (aR[i] == null) {
				return null;
			}
			if (plate.equals(aR[i].getPlatenum())) {
				return aR[i];
			}
		}
		return null;
	}
	
	//--------------------------------------------------------	
	
	/**
	 * Grabs Array
	 * @return Car Array
	 */
	public Car[] getAr() {
		return aR;
	}
	
	/**
	 * Is array full
	 * @return isFull
	 */
	public boolean isFull() {
		return amountSpaces == 0;
	}
	
	@Override
	public String toString() {
		return "CarsArray has " + amountCars + " cars inside and " + amountSpaces + " free spaces.";
	}
	
}
