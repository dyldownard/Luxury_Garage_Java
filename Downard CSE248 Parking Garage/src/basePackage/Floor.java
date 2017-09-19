package basePackage;

public class Floor {

	private FloorsArray parentAr;
	private CarsArray floorCarsAr;
	
	private int amountCars;
	private int amountSpaces;
	
//--------------------------------------------------------	
	
	public Floor(int spaces, FloorsArray parent) {
		parentAr = parent;
		floorCarsAr = new CarsArray(spaces);
		amountSpaces = spaces;
		amountCars = 0;
	}

//--------------------------------------------------------	
	
	public CarsArray getCarsAr() {
		return floorCarsAr;
	}
	public int getAmountCars() {
		return amountCars;
	}
	public int getAmountSpaces() {
		return amountSpaces;
	}
	
	@Override
	public String toString() {
		return " has " + amountCars + " cars with " + amountSpaces + " free spaces. \n		" + floorCarsAr;
	}
}
