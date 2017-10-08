package basePackage;

import carsPackage.Car;
import guiApplication.GUIFloor;
import guiApplication.ToolTipStackPane;

public class GroundFloor implements Floor {

	private int floorNum;

	private CarsArray NormalCarsAr;
	private CarsArray MotorcycleAr;
	private CarsArray HandiAr;
	private CarsArray BusAr;
	
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
	
	
	public GroundFloor(int spaces, int floorNum, ParkingGarage lot) {
		this.floorNum = floorNum;
		NormalCarsAr = new CarsArray(spaces);
		MotorcycleAr = new CarsArray(amountMotoSpaces);
		HandiAr = new CarsArray(amountHandiSpaces);
		BusAr = new CarsArray(amountBusSpaces);
		lot.AMOUNT_TOTAL_SPACES = lot.AMOUNT_TOTAL_SPACES + amountMotoSpaces + amountHandiSpaces + amountBusSpaces;
		amountNormalSpaces = spaces;
		amountNormalEmpty = spaces;
		amountNormalCars = 0;
	}
	
	
	@Override
	public String parkCar(Car myCar, GUIFloor floor, int spot, ToolTipStackPane pane) {
		if (pane.getActualType().equals("Normal")) {
			CarParked();
			return NormalCarsAr.parkCar(myCar, floor, pane.getSpecialSpot());
		}else if(pane.getActualType().equals("Motorcycle")) {
			MotoParked();
			return MotorcycleAr.parkCar(myCar, floor, pane.getSpecialSpot());
		}else if(pane.getActualType().equals("Large")) {
			BusParked();
			return BusAr.parkCar(myCar, floor, pane.getSpecialSpot());
		}else if(pane.getActualType().equals("Handicapped")) {
			HandiParked();
			return HandiAr.parkCar(myCar, floor, pane.getSpecialSpot());			
		}
		return "Error";
	}

	
	@Override
	public String parkValet(Car myCar, ParkingGarage park) {
		if (myCar.getSpaceType().equals("Handicapped") && amountHandiEmpty != 0) {
			HandiParked();
			return HandiAr.parkValet(myCar, park);
		}else if(myCar.getSpaceType().equals("Motorcycle") && amountMotoEmpty != 0) {
			MotoParked();
			return MotorcycleAr.parkValet(myCar, park);
		}else if(myCar.getSpaceType().equals("Large") && amountBusEmpty != 0) {
			BusParked();
			return BusAr.parkValet(myCar, park);
		}else if((myCar.getSpaceType().equals("Normal") || myCar.getSpaceType().equals("Motorcycle") || myCar.getSpaceType().equals("Handicapped")) && amountNormalEmpty != 0) {
			CarParked();
			return NormalCarsAr.parkValet(myCar, park);
		}
		return "Lot full for car type: " + myCar.getSpaceType();
	}

	
	@Override
	public int getFloorNum() {
		return this.floorNum;
	}

	@Override
	public CarsArray getCarsAr() {
		return this.NormalCarsAr;
	}
	

	@Override
	public int getAmountCars() {
		return this.amountNormalCars;
	}

	@Override
	public int getAmountTotalSpaces() {
		return this.amountNormalSpaces;
	}

	@Override
	public int getAmountSpaces() {
		return this.amountNormalSpaces;
	}

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

	@Override
	public void CarParked() {
		this.amountNormalCars++;
		this.amountNormalSpaces--;
	}

	@Override
	public void MotoParked() {
		this.amountMotoCars++;
		this.amountMotoEmpty--;
	}

	@Override
	public void BusParked() {
		this.amountBusCars++;
		this.amountBusEmpty--;
	}

	@Override
	public void HandiParked() {
		this.amountHandiCars++;
		this.amountHandiEmpty--;
	}


	@Override
	public String[] getTypesAllowed() {
		return this.AllowedTypes;
	}


	@Override
	public int getBusAmount() {
		return this.amountBusSpaces;
	}


	@Override
	public int getHandiAmount() {
		return this.amountHandiSpaces;
	}


	@Override
	public int getMotoAmount() {
		return this.amountMotoSpaces;
	}


	@Override
	public CarsArray getMotoAr() {
		return this.MotorcycleAr;
	}


	@Override
	public CarsArray getHandiAr() {
		return this.HandiAr;
	}


	@Override
	public CarsArray getBusAr() {
		return this.BusAr;
	}
}
