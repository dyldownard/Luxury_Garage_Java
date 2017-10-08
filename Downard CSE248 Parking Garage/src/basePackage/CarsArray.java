package basePackage;

import carsPackage.*;
import guiApplication.GUIFloor;

public class CarsArray {

	private Car[] aR;
	protected int amountCars;
	protected int amountSpaces;

	
	public CarsArray(int amount) {
		aR = new Car[amount];
		amountCars = 0;
		amountSpaces = amount;
	}
	

	public String parkCar(Car myCar, GUIFloor floor, Floor parent, int space) {
		aR[space] = myCar;
		amountSpaces--;
		amountCars++;
		parent.CarParked();
		floor.getGarage().CarParked();
		floor.getGarage().getTicketsArray().addTicket(myCar.getTicket());
		return "Car Parked.";
	}
	
	public String parkValet(Car myCar, Floor floor) {
		// TODO assign to cartype and floortype
		if (amountSpaces!=0 & amountCars!=100) {
			aR[amountCars] = myCar;
			amountSpaces--;
			amountCars++;
			floor.CarParked();
			ParkingGarage.CarParked();
			return "Car Parked.";
		}
		return "Car could not be parked. Error at CarArray.";
	}
	
	public Car[] getAr() {
		return aR;
	}
	
	@Override
	public String toString() {
		return "CarsArray has " + amountCars + " cars inside and " + amountSpaces + " free spaces.";
	}
	
}
