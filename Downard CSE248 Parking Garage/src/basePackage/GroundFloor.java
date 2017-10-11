package basePackage;

import carsPackage.Car;
import guiApplication.GUIFloor;
import guiApplication.ToolTipStackPane;

/**
 * Ground Floor has several types of Vehicles able to park in it
 */
public class GroundFloor implements Floor {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4336287979751206180L;

	/**
	 * floorNum Number of floor
	 */ 
	private int floorNum;

	private CarsArray NormalCarsAr;
	private CarsArray MotorcycleAr;
	private CarsArray HandiAr;
	private CarsArray BusAr;
	/**
	 * AllowedTypes Allowed types of Vehicle able to park on the floor
	 */
	private String[] AllowedTypes = {"Normal", "Motorcycle", "Large", "Handicapped"};
	
	protected int amountNormalSpaces;
	protected int amountNormalCars;
	protected int amountNormalEmpty;
	
	protected int amountMotoSpaces = 15;
	protected int amountMotoCars = 0;	// yes, this is a redundant name
	protected int amountMotoEmpty = amountMotoSpaces;
	
	protected int amountHandiSpaces = 15;
	protected int amountHandiCars = 0;
	protected int amountHandiEmpty = amountHandiSpaces;
	
	protected int amountBusSpaces = 5;
	protected int amountBusCars = 0;
	protected int amountBusEmpty = amountBusSpaces;
	
	
	//--------------------------------------------------------	
	
	/**
	 * @param spaces Amount of spaces in the lot
	 * @param floorNum Number of floor in Array
	 * @param lot Parent Parkinglot
	 */
	public GroundFloor(int spaces, int floorNum, ParkingGarage lot) {
		this.floorNum = floorNum;
		NormalCarsAr = new CarsArray(spaces, lot);
		MotorcycleAr = new CarsArray(amountMotoSpaces, lot);
		HandiAr = new CarsArray(amountHandiSpaces, lot);
		BusAr = new CarsArray(amountBusSpaces, lot);
		lot.AMOUNT_TOTAL_SPACES = lot.AMOUNT_TOTAL_SPACES + amountMotoSpaces + amountHandiSpaces + amountBusSpaces;
		amountNormalSpaces = spaces;
		amountNormalEmpty = spaces;
		amountNormalCars = 0;
	}
	
	//--------------------------------------------------------	
	
	/* (non-Javadoc)
	 * @see basePackage.Floor#parkCar(carsPackage.Car, guiApplication.GUIFloor, int, guiApplication.ToolTipStackPane)
	 */
	@Override
	public String parkCar(Car myCar, GUIFloor floor, int spot, ToolTipStackPane pane) {
		if (pane.getActualType().equals("Normal")) {
			myCar.setFloor(this);
			myCar.setFloorCarAr(NormalCarsAr);
			CarParked();
			return NormalCarsAr.parkCar(myCar, floor, pane.getSpecialSpot());
		}else if(pane.getActualType().equals("Motorcycle")) {
			myCar.setFloor(this);
			myCar.setFloorCarAr(MotorcycleAr);
			MotoParked();
			return MotorcycleAr.parkCar(myCar, floor, pane.getSpecialSpot());
		}else if(pane.getActualType().equals("Large")) {
			myCar.setFloor(this);
			myCar.setFloorCarAr(BusAr);
			BusParked();
			return BusAr.parkCar(myCar, floor, pane.getSpecialSpot());
		}else if(pane.getActualType().equals("Handicapped")) {
			myCar.setFloor(this);
			myCar.setFloorCarAr(HandiAr);
			HandiParked();
			return HandiAr.parkCar(myCar, floor, pane.getSpecialSpot());			
		}
		return "Error";
	}

	
	/* (non-Javadoc)
	 * @see basePackage.Floor#parkValet(carsPackage.Car, basePackage.ParkingGarage)
	 */
	@Override
	public String parkValet(Car myCar, ParkingGarage park) {
		if (myCar.getSpaceType().equals("Handicapped") && amountHandiEmpty != 0) {
			myCar.setFloor(this);
			myCar.setFloorCarAr(NormalCarsAr);
			HandiParked();
			return HandiAr.parkValet(myCar, park);
		}else if(myCar.getSpaceType().equals("Motorcycle") && amountMotoEmpty != 0) {
			myCar.setFloor(this);
			myCar.setFloorCarAr(MotorcycleAr);
			MotoParked();
			return MotorcycleAr.parkValet(myCar, park);
		}else if(myCar.getSpaceType().equals("Large") && amountBusEmpty != 0) {
			myCar.setFloor(this);
			myCar.setFloorCarAr(BusAr);
			BusParked();
			return BusAr.parkValet(myCar, park);
		}else if((myCar.getSpaceType().equals("Normal") || myCar.getSpaceType().equals("Motorcycle") || myCar.getSpaceType().equals("Handicapped")) && amountNormalEmpty != 0) {
			myCar.setFloor(this);
			myCar.setFloorCarAr(HandiAr);
			CarParked();
			return NormalCarsAr.parkValet(myCar, park);
		}
		return "Lot full for car type: " + myCar.getSpaceType();
	}

	//--------------------------------------------------------	

	/* (non-Javadoc)
	 * @see basePackage.Floor#carPicked(carsPackage.Car)
	 */
	@Override
	public void carPicked(Car myCar) {
		switch (myCar.getSpaceType()) {
		case "Large": this.amountBusCars--; this.amountBusEmpty++;
		case "Normal": this.amountNormalCars--; this.amountNormalEmpty++;
		case "Handicapped": this.amountHandiCars--; this.amountHandiEmpty++;
		case "Motorcycle": this.amountMotoCars--; this.amountMotoEmpty++;
		}
	}
	
	//--------------------------------------------------------	
	
	/* (non-Javadoc)
	 * @see basePackage.Floor#isFull(java.lang.String)
	 */
	@Override
	public boolean isFull(String spaceType) {
		switch (spaceType) {
		case "Large": return BusAr.isFull();
		case "Normal": return NormalCarsAr.isFull();
		case "Handicapped": return HandiAr.isFull();
		case "Motorcycle": return MotorcycleAr.isFull();
		}
		return true;
	}
	
	/* (non-Javadoc)
	 * @see basePackage.Floor#getFloorNum()
	 */
	@Override
	public int getFloorNum() {
		return this.floorNum;
	}

	/* (non-Javadoc)
	 * @see basePackage.Floor#getCarsAr()
	 */
	@Override
	public CarsArray getCarsAr() {
		return this.NormalCarsAr;
	}
	

	/* (non-Javadoc)
	 * @see basePackage.Floor#getAmountCars()
	 */
	@Override
	public int getAmountCars() {
		return this.amountNormalCars;
	}

	/* (non-Javadoc)
	 * @see basePackage.Floor#getAmountTotalSpaces()
	 */
	@Override
	public int getAmountTotalSpaces() {
		return this.amountNormalSpaces;
	}

	/* (non-Javadoc)
	 * @see basePackage.Floor#getAmountSpaces()
	 */
	@Override
	public int getAmountSpaces() {
		return this.amountNormalSpaces;
	}

	/* (non-Javadoc)
	 * @see basePackage.Floor#CarParked()
	 */
	@Override
	public void CarParked() {
		this.amountNormalCars++;
		this.amountNormalEmpty--;
	}

	/* (non-Javadoc)
	 * @see basePackage.Floor#MotoParked()
	 */
	@Override
	public void MotoParked() {
		this.amountMotoCars++;
		this.amountMotoEmpty--;
	}

	/* (non-Javadoc)
	 * @see basePackage.Floor#BusParked()
	 */
	@Override
	public void BusParked() {
		this.amountBusCars++;
		this.amountBusEmpty--;
	}

	/* (non-Javadoc)
	 * @see basePackage.Floor#HandiParked()
	 */
	@Override
	public void HandiParked() {
		this.amountHandiCars++;
		this.amountHandiEmpty--;
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
		return this.amountBusSpaces;
	}


	/* (non-Javadoc)
	 * @see basePackage.Floor#getHandiAmount()
	 */
	@Override
	public int getHandiAmount() {
		return this.amountHandiSpaces;
	}


	/* (non-Javadoc)
	 * @see basePackage.Floor#getMotoAmount()
	 */
	@Override
	public int getMotoAmount() {
		return this.amountMotoSpaces;
	}


	/* (non-Javadoc)
	 * @see basePackage.Floor#getMotoAr()
	 */
	@Override
	public CarsArray getMotoAr() {
		return this.MotorcycleAr;
	}


	/* (non-Javadoc)
	 * @see basePackage.Floor#getHandiAr()
	 */
	@Override
	public CarsArray getHandiAr() {
		return this.HandiAr;
	}


	/* (non-Javadoc)
	 * @see basePackage.Floor#getBusAr()
	 */
	@Override
	public CarsArray getBusAr() {
		return this.BusAr;
	}
}
