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
	

	public String parkCar(Car myCar, GUIFloor floor, int space) {
		aR[space] = myCar;
		amountSpaces--;
		amountCars++;
		floor.getGarage().CarParked();
		floor.getGarage().getCarsArray().AddCarLot(myCar);
		floor.getGarage().getTicketsArray().addTicket(myCar.getTicket());
		return "Car Parked.";
	}
	
	public String parkValet(Car myCar, ParkingGarage park) {
		// TODO assign to cartype and floortype
		aR[amountCars] = myCar;
		amountSpaces--;
		amountCars++;
		park.CarParked();
		park.getCarsArray().AddCarLot(myCar);
		return "Car Parked.";
	}
	
	public boolean isFull() {
		return amountSpaces == 0;
	}
	
	public void AddCarLot(Car myCar) {
		aR[amountCars] = myCar;
		amountSpaces--;
		amountCars++;
	}
	
	public Car[] getAr() {
		return aR;
	}
	
	@Override
	public String toString() {
		return "CarsArray has " + amountCars + " cars inside and " + amountSpaces + " free spaces.";
	}
	
}
