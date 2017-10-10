package basePackage;

import carsPackage.Car;
import guiApplication.GUIFloor;
import guiApplication.ToolTipStackPane;

public class NormalFloor implements Floor {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8402432774992136787L;
	private int floorNum;
	private CarsArray floorCarsAr;
	
	private String[] AllowedTypes = {"Normal", "Handicapped", "Motorcycle"};
	
	protected int amountTotalSpaces;
	protected int amountCars;
	protected int amountSpaces;
	
	//--------------------------------------------------------	
	
	public NormalFloor(int spaces, int floorNum, ParkingGarage lot) {
		this.floorNum = floorNum;
		floorCarsAr = new CarsArray(spaces, lot);
		amountTotalSpaces = spaces;
		amountSpaces = spaces;
		amountCars = 0;
	}

	//--------------------------------------------------------	
	@Override
	public String parkCar(Car myCar, GUIFloor floor, int spot, ToolTipStackPane pane) {
		myCar.setFloor(this);
		myCar.setFloorCarAr(floorCarsAr);
		CarParked();
		return floorCarsAr.parkCar(myCar, floor, spot);
	}
	
	@Override
	public String parkValet(Car myCar, ParkingGarage park) {
		myCar.setFloor(this);
		myCar.setFloorCarAr(floorCarsAr);
		CarParked();
		return floorCarsAr.parkValet(myCar, park);
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
	public boolean isFull(String type) {
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

	@Override
	public String[] getTypesAllowed() {
		return this.AllowedTypes;
	}

	@Override
	public int getBusAmount() {
		return 0;
	}

	@Override
	public int getHandiAmount() {
		return 0;
	}

	@Override
	public int getMotoAmount() {
		return 0;
	}

	@Override
	public CarsArray getMotoAr() {
		return null;
	}

	@Override
	public CarsArray getHandiAr() {
		return null;
	}

	@Override
	public CarsArray getBusAr() {
		return null;
	}

	@Override
	public void carPicked(Car myCar) {
		this.amountCars--;
		this.amountSpaces++;
	}
	
}
