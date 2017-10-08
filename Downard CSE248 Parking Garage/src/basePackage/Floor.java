package basePackage;

import carsPackage.*;
import guiApplication.GUIFloor;
import guiApplication.ToolTipStackPane;

public interface Floor {

	public String parkValet(Car myCar);
	public String parkCar(Car myCar, GUIFloor floor, int spot, ToolTipStackPane pane);
	public int getFloorNum();
	public CarsArray getCarsAr();
	public int getAmountCars();
	public int getAmountTotalSpaces();
	public int getAmountSpaces();
	public boolean isFull();
	public void CarParked();
	public void MotoParked();
	public void BusParked();
	public void HandiParked();
	
}
