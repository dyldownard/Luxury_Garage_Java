package guiApplication;

import basePackage.*;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;

public class TabPanes {

	private TabPane tpane;
	private Tab[] tabAr;
	private GUIFloor[] floorGUIAr;
	
	public TabPanes(ParkingGarage CarPark) {
		//TODO MAKE TABPANES
		int floors = CarPark.AMOUNT_FLOORS;
		tpane = new TabPane();
		tabAr = new Tab[floors];
		floorGUIAr = new GUIFloor[floors];
		for (int i = 0; i < floors; i++) {
			//TODO create Floors
			if (CarPark.getFloorsArray().getAr()[i] instanceof /*Normal*/Floor) {
				tabAr[i] = new Tab("Floor " + (i + 1));
				NormalFloorPane newFloor = new NormalFloorPane(CarPark, i);
				floorGUIAr[i] = newFloor;
				tabAr[i].setContent(newFloor.getGridPane());
				tabAr[i].setClosable(false);
			}
			tpane.getTabs().add(tabAr[i]);
		}
		
		
		
	}
	
	public void updateGrid() {
		for (int i = 0; i < floorGUIAr.length; i++) {
			floorGUIAr[i].updateGrid();
		}
	}
	
	
	public TabPane getTabPane() {
		return this.tpane;
	}
	
	
}
