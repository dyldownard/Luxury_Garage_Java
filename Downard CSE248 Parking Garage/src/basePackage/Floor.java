package basePackage;

import carsPackage.*;
import guiApplication.GUIFloor;
import guiApplication.ToolTipStackPane;

public interface Floor {

	public String parkValet(Car myCar, ParkingGarage park);
	public String parkCar(Car myCar, GUIFloor floor, int spot, ToolTipStackPane pane);
	public String[] getTypesAllowed();
	public int getFloorNum();
	public CarsArray getCarsAr();
	public CarsArray getMotoAr();
	public CarsArray getHandiAr();
	public CarsArray getBusAr();
	public int getAmountCars();
	public int getAmountTotalSpaces();
	public int getAmountSpaces();
	public int getBusAmount();
	public int getHandiAmount();
	public int getMotoAmount();
	public boolean isFull(String spaceType);
	public void CarParked();
	public void MotoParked();
	public void BusParked();
	public void HandiParked();
	public void carPicked(Car myCar);
	
}
