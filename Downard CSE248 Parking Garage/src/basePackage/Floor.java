package basePackage;

public class Floor {

	private int floorNum;
	private CarsArray floorCarsAr;
	
	protected int amountCars;
	protected int amountSpaces;
	
	//--------------------------------------------------------	
	
	public Floor(int spaces, int floorNum) {
		this.floorNum = floorNum;
		floorCarsAr = new CarsArray(spaces);
		
		amountSpaces = spaces;
		amountCars = 0;
	}

	//--------------------------------------------------------	
	
	public String parkValet(Car myCar) {
		return floorCarsAr.parkValet(myCar, this);
	}
	
	//--------------------------------------------------------		
	
	public int getFloorNum() {
		return floorNum;
	}
	public CarsArray getCarsAr() {
		return floorCarsAr;
	}
	public int getAmountCars() {
		return amountCars;
	}
	public int getAmountSpaces() {
		return amountSpaces;
	}
	public boolean isFull() {
		return (amountSpaces == 0);
	}
	
	
	@Override
	public String toString() {
		return " has " + amountCars + " cars with " + amountSpaces + " free spaces. \n		" + floorCarsAr;
	}
}
