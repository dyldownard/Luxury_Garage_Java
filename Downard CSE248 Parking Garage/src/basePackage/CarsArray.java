package basePackage;

public class CarsArray {

	private Car[] aR;
	protected int amountCars;
	protected int amountSpaces;

	
	public CarsArray(int amount) {
		aR = new Car[amount];
		amountCars = 0;
		amountSpaces = amount;
	}
	

	public boolean parkCarSpecific(Car myCar, int space) {
		if (aR[space - 1] == null) {
			aR[space] = myCar;
			amountSpaces--;
			amountCars++;
			return true;
		}
		return false;
	}
	
	public String parkValet(Car myCar, Floor floor) {
		if (amountSpaces!=0 & amountCars!=100) {
			aR[amountCars] = myCar;
			amountSpaces--;
			floor.amountSpaces--;
			amountCars++;
			floor.amountCars++;
			ParkingGarage.CarParked();
			return "Car Parked.";
		}
		return "Car could not be parked. Error at CarArray.";
	}
	
	@Override
	public String toString() {
		return "CarsArray has " + amountCars + " cars inside and " + amountSpaces + " free spaces.";
	}
	
}
