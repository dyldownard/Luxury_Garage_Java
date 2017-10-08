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
	
	protected int amountNormalSpaces;
	protected int amountNormalCars;
	protected int amountNormalEmpty;
	
	protected int amountMotoSpaces = 15;
	protected int amountMotoCars = 0;	// yes, this is a redundant name
	protected int amountMotoEmpty = amountMotoSpaces;
	
	protected int amountHandiSpaces = 15;
	protected int amountHandiCars = 0;
	protected int amountHandiEmpty = amountHandiSpaces;
	
	protected int amountBusSpaces = 15;
	protected int amountBusCars = 0;
	protected int amountBusEmpty = amountBusSpaces;
	
	
	public GroundFloor(int spaces, int floorNum, ParkingGarage lot) {
		this.floorNum = floorNum;
		NormalCarsAr = new CarsArray(spaces);
		MotorcycleAr = new CarsArray(amountMotoSpaces);
		HandiAr = new CarsArray(amountHandiSpaces);
		BusAr = new CarsArray(amountHandiSpaces);
		lot.AMOUNT_TOTAL_SPACES = lot.AMOUNT_TOTAL_SPACES + amountMotoSpaces + amountHandiSpaces + amountBusSpaces;
		amountNormalSpaces = spaces;
		amountNormalEmpty = spaces;
		amountNormalCars = 0;
	}
	
	
	@Override
	public String parkCar(Car myCar, GUIFloor floor, int spot, ToolTipStackPane pane) {
		if (pane.getActualType().equals("Normal")) {
			CarParked();
			return NormalCarsAr.parkCar(myCar, floor, this, spot);
		}else if(pane.getActualType().equals("Motorcycle")) {
			MotoParked();
			return MotorcycleAr.parkCar(myCar, floor, this, spot);
		}else if(pane.getActualType().equals("Bus")) {
			BusParked();
			return BusAr.parkCar(myCar, floor, this, spot);
		}else if(pane.getActualType().equals("Handicap")) {
			HandiParked();
			return HandiAr.parkCar(myCar, floor, this, spot);			
		}
		return "Error";
	}

	
	@Override
	public String parkValet(Car myCar) {
		//todo stiff
		return null;
	}

	
	@Override
	public int getFloorNum() {
		return 0;
	}

	@Override
	public CarsArray getCarsAr() {
		return null;
	}

	@Override
	public int getAmountCars() {
		return 0;
	}

	@Override
	public int getAmountTotalSpaces() {
		return 0;
	}

	@Override
	public int getAmountSpaces() {
		return 0;
	}

	@Override
	public boolean isFull() {
		return false;
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
}
