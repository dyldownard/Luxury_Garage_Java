package guiApplication;

import java.io.Serializable;

import basePackage.ParkingGarage;
/**
 *Layout for the GUI floors
 */
public interface GUIFloor extends Serializable {
	/**
	 * updates gridpane to actual car array
	 */
	public void updateGrid();
	/**
	 * gets stackpanes from the floor
	 * @return Stackpane array
	 */
	public ToolTipStackPane[] getStackPanes();
	/**
	 * gets number of floor
	 * @return floor num
	 */
	public int getFloorNum();
	/**
	 * gets ParkingGarage from floor
	 * @return parkinggarage
	 */
	public ParkingGarage getGarage();
}
