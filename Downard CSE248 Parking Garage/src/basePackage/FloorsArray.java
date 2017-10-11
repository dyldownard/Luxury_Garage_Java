package basePackage;

import java.io.Serializable;
import java.util.Arrays;

import carsPackage.Car;
import guiApplication.GUIFloor;
import guiApplication.ToolTipStackPane;

public class FloorsArray implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 774220173256562317L;
	private Floor[] aR;
	
	//--------------------------------------------------------		
	
	/**
	 * @param types Array of Floors, given in the order of the floors
	 * @param spaces Amount of {Normal} spaces in the garage
	 * @param lot the Parent ParkingLot
	 */
	public FloorsArray(String[] types, int spaces, ParkingGarage lot) {
		aR = new Floor[types.length];
		for (int i = 0; i < types.length; i++) {
			if (types[i].equals("NormalFloor")) {
				aR[i] = new NormalFloor(spaces/types.length, i, lot);
			}else if (types[i].equals("GroundFloor")) {
				aR[i] = new GroundFloor(spaces/types.length, i, lot);
			}
		}
	}

	//--------------------------------------------------------	
	/**
	 * @param myCar Car to be parked
	 * @param floor GUIFloor the car came from
	 * @param spot Spot the car came from on the GUI
	 * @param pane Pane with the car in it
	 */
	public String parkCar(Car myCar, GUIFloor floor, int spot, ToolTipStackPane pane) {
		return aR[floor.getFloorNum()].parkCar(myCar, floor, spot, pane);
	}
	
	/**
	 * @param myCar Car being parked
	 * @param park Parent ParkingLot
	 */
	public String parkValet(Car myCar, ParkingGarage park) {
		for (int i = 0; i < aR.length; i++) {
			if (aR[i].isFull(myCar.getSpaceType()) == false && Arrays.asList(aR[i].getTypesAllowed()).contains(myCar.getSpaceType())) {
				return aR[i].parkValet(myCar, park);
			}
		}
		return "Cannot park car, no spots available.";
	}
	
	//--------------------------------------------------------		
	
	/**
	 * @return returns Floor Array
	 */
	public Floor[] getAr() {
		return aR;
	}
	
}
