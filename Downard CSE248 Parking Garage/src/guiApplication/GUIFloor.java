package guiApplication;

import java.io.Serializable;

import basePackage.ParkingGarage;

public interface GUIFloor extends Serializable {
	public void updateGrid();
	public ToolTipStackPane[] getStackPanes();
	public int getFloorNum();
	public ParkingGarage getGarage();
}
