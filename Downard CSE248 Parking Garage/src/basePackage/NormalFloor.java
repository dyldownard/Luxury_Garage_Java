package basePackage;

import carsPackage.Car;
import guiApplication.GUIFloor;
import guiApplication.ToolTipStackPane;
/**
 * 
 * Normal floor - able to park cars with space type of "Normal"
 *
 */
public class NormalFloor implements Floor {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8402432774992136787L;
	private int floorNum;
	private CarsArray floorCarsAr;
	
	/**
	 * AllowedTypes allowed types of cars on floor
	 */
	private String[] AllowedTypes = {"Normal", "Handicapped", "Motorcycle"};
	
	protected int amountTotalSpaces;
	protected int amountCars;
	protected int amountSpaces;
	
	//--------------------------------------------------------	
	
	/**
	 * @param spaces amount of spaces on floor
	 * @param floorNum number of floor in array
	 * @param lot Parent Parkinglot
	 */
	public NormalFloor(int spaces, int floorNum, ParkingGarage lot) {
		this.floorNum = floorNum;
		floorCarsAr = new CarsArray(spaces, lot);
		amountTotalSpaces = spaces;
		amountSpaces = spaces;
		amountCars = 0;
	}

	//--------------------------------------------------------	
	/* (non-Javadoc)
	 * @see basePackage.Floor#parkCar(carsPackage.Car, guiApplication.GUIFloor, int, guiApplication.ToolTipStackPane)
	 */
	@Override
	public String parkCar(Car myCar, GUIFloor floor, int spot, ToolTipStackPane pane) {
		myCar.setFloor(this);
		myCar.setFloorCarAr(floorCarsAr);
		CarParked();
		return floorCarsAr.parkCar(myCar, floor, spot);
	}
	
	/* (non-Javadoc)
	 * @see basePackage.Floor#parkValet(carsPackage.Car, basePackage.ParkingGarage)
	 */
	@Override
	public String parkValet(Car myCar, ParkingGarage park) {
		myCar.setFloor(this);
		myCar.setFloorCarAr(floorCarsAr);
		CarParked();
		return floorCarsAr.parkValet(myCar, park);
	}
	
	//--------------------------------------------------------		
	
	/* (non-Javadoc)
	 * @see basePackage.Floor#getFloorNum()
	 */
	@Override
	public int getFloorNum() {
		return floorNum;
	}
	/* (non-Javadoc)
	 * @see basePackage.Floor#getCarsAr()
	 */
	@Override
	public CarsArray getCarsAr() {
		return floorCarsAr;
	}
	/* (non-Javadoc)
	 * @see basePackage.Floor#getAmountCars()
	 */
	@Override
	public int getAmountCars() {
		return amountCars;
	}
	/* (non-Javadoc)
	 * @see basePackage.Floor#getAmountTotalSpaces()
	 */
	@Override
	public int getAmountTotalSpaces() {
		return amountTotalSpaces;
	}
	/* (non-Javadoc)
	 * @see basePackage.Floor#getAmountSpaces()
	 */
	@Override
	public int getAmountSpaces() {
		return amountSpaces;
	}
	/* (non-Javadoc)
	 * @see basePackage.Floor#isFull(java.lang.String)
	 */
	@Override
	public boolean isFull(String type) {
		return (amountSpaces == 0);
	}
	@Override
	public String toString() {
		return " has " + amountCars + " cars with " + amountSpaces + " free spaces. \n		" + floorCarsAr;
	}
	/* (non-Javadoc)
	 * @see basePackage.Floor#CarParked()
	 */
	@Override
	public void CarParked() {
		this.amountCars++;
		this.amountSpaces--;
	}

	/* (non-Javadoc)
	 * @see basePackage.Floor#MotoParked()
	 */
	@Override
	public void MotoParked() {	// following three methods unused since there are not specific spots for them on this floor
	}

	/* (non-Javadoc)
	 * @see basePackage.Floor#BusParked()
	 */
	@Override
	public void BusParked() {
	}

	/* (non-Javadoc)
	 * @see basePackage.Floor#HandiParked()
	 */
	@Override
	public void HandiParked() {
	}

	/* (non-Javadoc)
	 * @see basePackage.Floor#getTypesAllowed()
	 */
	@Override
	public String[] getTypesAllowed() {
		return this.AllowedTypes;
	}

	/* (non-Javadoc)
	 * @see basePackage.Floor#getBusAmount()
	 */
	@Override
	public int getBusAmount() {
		return 0;
	}

	/* (non-Javadoc)
	 * @see basePackage.Floor#getHandiAmount()
	 */
	@Override
	public int getHandiAmount() {
		return 0;
	}

	/* (non-Javadoc)
	 * @see basePackage.Floor#getMotoAmount()
	 */
	@Override
	public int getMotoAmount() {
		return 0;
	}

	/* (non-Javadoc)
	 * @see basePackage.Floor#getMotoAr()
	 */
	@Override
	public CarsArray getMotoAr() {
		return null;
	}

	/* (non-Javadoc)
	 * @see basePackage.Floor#getHandiAr()
	 */
	@Override
	public CarsArray getHandiAr() {
		return null;
	}

	/* (non-Javadoc)
	 * @see basePackage.Floor#getBusAr()
	 */
	@Override
	public CarsArray getBusAr() {
		return null;
	}

	/* (non-Javadoc)
	 * @see basePackage.Floor#carPicked(carsPackage.Car)
	 */
	@Override
	public void carPicked(Car myCar) {
		this.amountCars--;
		this.amountSpaces++;
	}
	
}
