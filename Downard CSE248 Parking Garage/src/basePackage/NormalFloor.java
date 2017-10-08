package basePackage;

import carsPackage.Car;
import guiApplication.GUIFloor;
import guiApplication.ToolTipStackPane;

public class NormalFloor implements Floor {

	private int floorNum;
	private CarsArray floorCarsAr;
	
	protected int amountTotalSpaces;
	protected int amountCars;
	protected int amountSpaces;
	
	//--------------------------------------------------------	
	
	public NormalFloor(int spaces, int floorNum) {
		this.floorNum = floorNum;
		floorCarsAr = new CarsArray(spaces);
		amountTotalSpaces = spaces;
		amountSpaces = spaces;
		amountCars = 0;
	}

	//--------------------------------------------------------	
	@Override
	public String parkCar(Car myCar, GUIFloor floor, int spot, ToolTipStackPane pane) {
		return floorCarsAr.parkCar(myCar, floor, this, spot);
	}
	@Override
	public String parkValet(Car myCar) {
		return floorCarsAr.parkValet(myCar, this);
	}
	
	//--------------------------------------------------------		
	
	@Override
	public int getFloorNum() {
		return floorNum;
	}
	@Override
	public CarsArray getCarsAr() {
		return floorCarsAr;
	}
	@Override
	public int getAmountCars() {
		return amountCars;
	}
	@Override
	public int getAmountTotalSpaces() {
		return amountTotalSpaces;
	}
	@Override
	public int getAmountSpaces() {
		return amountSpaces;
	}
	@Override
	public boolean isFull() {
		return (amountSpaces == 0);
	}
	@Override
	public String toString() {
		return " has " + amountCars + " cars with " + amountSpaces + " free spaces. \n		" + floorCarsAr;
	}
	@Override
	public void CarParked() {
		this.amountCars++;
		this.amountSpaces--;
	}

	@Override
	public void MotoParked() {	// following three methods unused since there are not specific spots for them on this floor
	}

	@Override
	public void BusParked() {
	}

	@Override
	public void HandiParked() {
	}
	
}
