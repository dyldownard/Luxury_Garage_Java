package basePackage;

public class CarsArray {

	private Car[] aR;
	private int amountCars;
	private int amountSpaces;

	
	public CarsArray(int amount) {
		aR = new Car[amount];
		amountCars = 0;
		amountSpaces = amount;
	}
	

	public Car parkCarSpecific(Car myCar, int space) {
		if (aR[space - 1] == null) {
			aR[space] = myCar;
			amountSpaces--;
			amountCars++;
		}
		return myCar;
	}
	public Car parkCarNonspecific(Car myCar) {
		if (amountSpaces!=0 & amountCars!=100) {
			aR[amountCars] = myCar;
			amountSpaces--;
			amountCars++;
		}
		return myCar;
	}
	
	@Override
	public String toString() {
		return "CarsArray has " + amountCars + " cars inside and " + amountSpaces + " free spaces.";
	}
	
}
