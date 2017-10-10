package basePackage;

import java.io.Serializable;

import carsPackage.*;
import guiApplication.GUIFloor;

public class CarsArray implements Serializable{

	private Car[] aR;
	protected int amountCars;
	protected int amountSpaces;
	private ParkingGarage mygarage;
	
	public CarsArray(int amount) {
		aR = new Car[amount];
		amountCars = 0;
		amountSpaces = amount;
	}
	

	public String parkCar(Car myCar, GUIFloor floor, int space) {
		System.out.println(space + "space");
		aR[space] = myCar;
		myCar.setSpotNum(space);
		amountSpaces--;
		amountCars++;
		floor.getGarage().CarParked();
		floor.getGarage().getCarsArray().AddCarLot(myCar);
		floor.getGarage().getTicketsArray().addTicket(myCar.getTicket());
		return "Car Parked.";
	}
	
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
	
	public boolean isFull() {
		return amountSpaces == 0;
	}
	
	public void CarPicked(Car myCar, int spotnum) {
		amountSpaces++;
		amountCars--;
		mygarage.CarPicked();
		this.aR[spotnum] = null;
		myCar.getFloor().carPicked(myCar);

	}
	

	public void AddCarLot(Car myCar) {
		int temp = 0;			//making sure that it gets the first slot available
		for (int i = 0; i < aR.length; i++) {
			if (aR[i] == null) {
				temp = i;
				break;
			}
		}
		aR[temp] = myCar;
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
